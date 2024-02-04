package com.yagmur.service;

import com.yagmur.entity.Category;
import com.yagmur.repository.CategoryRepository;
import com.yagmur.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICrudService<Category,Long> {

    private final CategoryRepository categoryRepository;
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Iterable<Category> saveAll(Iterable<Category> t) {
        return categoryRepository.saveAll(t);
    }

    @Override
    public Category deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<Category> findById(Long aLong) {
        return categoryRepository.findById(aLong);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
