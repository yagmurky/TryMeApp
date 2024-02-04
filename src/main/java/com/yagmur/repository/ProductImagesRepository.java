package com.yagmur.repository;

import com.yagmur.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {

    Optional<ProductImages> findByName(String fileName);
}
