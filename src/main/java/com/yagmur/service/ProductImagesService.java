package com.yagmur.service;

import com.yagmur.entity.ProductImages;
import com.yagmur.repository.ProductImagesRepository;
import com.yagmur.repository.ProductRepository;
import com.yagmur.utility.ICrudService;
import com.yagmur.utility.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductImagesService implements ICrudService<ProductImages, Long> {
    private final ProductImagesRepository productImagesRepository;
    private final ProductRepository productRepository;

    @Override
    public ProductImages save(ProductImages productImages) {
        return productImagesRepository.save(productImages);
    }

    @Override
    public ProductImages update(ProductImages productImages) {
        return null;
    }

    @Override
    public Iterable<ProductImages> saveAll(Iterable<ProductImages> t) {
        return null;
    }

    @Override
    public ProductImages deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<ProductImages> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<ProductImages> findAll() {
        return null;
    }

    public void saveImage(MultipartFile file, Long productId) throws IOException {
        ProductImages productImages = new ProductImages();
        productImages.setImage(file.getBytes().toString());
        // Belirli bir ürünle ilişkilendirmek için productId kullanılabilir.
        productImages.setProduct(productRepository.findById(productId).orElse(null));
        productImagesRepository.save(productImages);
    }

    public String uploadImage(MultipartFile file) throws IOException {
        ProductImages productImages = productImagesRepository.save(ProductImages.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes().toString()).build());
        if(productImages != null) {
            return productImages.getName() + "." + productImages.getType() + " saved successfully.";
        }
        return null;
    }





}
