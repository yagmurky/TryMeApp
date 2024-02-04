package com.yagmur.service;

import com.yagmur.entity.Product;
import com.yagmur.repository.ProductRepository;
import com.yagmur.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements ICrudService<Product, Long> {


    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> saveAll(Iterable<Product> t) {
        return productRepository.saveAll(t);
    }

    @Override
    public Product deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return productRepository.findById(aLong);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }


}
