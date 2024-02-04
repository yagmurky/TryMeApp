package com.yagmur.service;

import com.yagmur.entity.VirtualTryOnImage;
import com.yagmur.repository.VirtualTryOnImageRepository;
import com.yagmur.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VirtualTryOnImageService implements ICrudService<VirtualTryOnImage,Long> {
    private final VirtualTryOnImageRepository virtualTryOnImageRepository;

    @Override
    public VirtualTryOnImage save(VirtualTryOnImage virtualTryOnImage) {
        return virtualTryOnImageRepository.save(virtualTryOnImage);
    }

    @Override
    public VirtualTryOnImage update(VirtualTryOnImage virtualTryOnImage) {
        return virtualTryOnImageRepository.save(virtualTryOnImage);
    }

    @Override
    public Iterable<VirtualTryOnImage> saveAll(Iterable<VirtualTryOnImage> t) {
        return virtualTryOnImageRepository.saveAll(t);
    }

    @Override
    public VirtualTryOnImage deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<VirtualTryOnImage> findById(Long aLong) {
        return virtualTryOnImageRepository.findById(aLong);
    }

    @Override
    public List<VirtualTryOnImage> findAll() {
        return virtualTryOnImageRepository.findAll();
    }
}
