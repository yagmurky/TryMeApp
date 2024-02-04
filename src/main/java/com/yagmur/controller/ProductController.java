package com.yagmur.controller;

import com.yagmur.entity.Product;
import com.yagmur.service.ProductImagesService;
import com.yagmur.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductImagesService productImagesService;

    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public ResponseEntity<String> addProduct(@RequestBody Product product, @RequestParam("file") MultipartFile file) {
        try {
            productService.save(product);
            productImagesService.saveImage(file, product.getId());
            return ResponseEntity.ok(product.getName() +"--> Product added successfully.");
        } catch (IOException exception) {
            return ResponseEntity.badRequest().body("Error adding product.");
        }
    }


}
