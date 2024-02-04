package com.yagmur.controller;

import com.yagmur.service.CloudinaryService;
import com.yagmur.service.VirtualTryOnImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/customer-images")
public class VirtualTryOnImageController {

    private final CloudinaryService cloudinaryService;
    private final VirtualTryOnImageService virtualTryOnImageService;

    @PostMapping(value = "/try-product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> tryProduct(@RequestParam("username") String name,@RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = cloudinaryService.uploadFile(file);
            return ResponseEntity.ok("Virtual try on successfully. URL: " + imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading image.");
        }
    }

}
