package com.yagmur.controller;

import com.yagmur.entity.Product;
import com.yagmur.entity.ProductImages;
import com.yagmur.service.CloudinaryService;
import com.yagmur.service.ProductImagesService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-images")
public class ProductImagesController {

    private final ProductImagesService productImagesService;
    private final CloudinaryService cloudinaryService;


    @PostMapping("/save/{productId}")
    public ResponseEntity<String> saveImage(@RequestParam("file") MultipartFile file, @PathVariable Long productId) {
        try {
            productImagesService.saveImage(file, productId);
            return ResponseEntity.ok("Image uploaded successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error uploading image.");
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = productImagesService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @PostMapping(value = "/add-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addImages(@RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = cloudinaryService.uploadFile(file);
            productImagesService.save(ProductImages.builder()
                    .image(imageUrl)
                    .build());
            return ResponseEntity.ok("Resim başarıyla yüklendi. URL: " + imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Resim yükleme hatası.");
        }
    }




}
