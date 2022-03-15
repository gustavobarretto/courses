package com.digitalbooking.backend.domain.service.impl;

import com.digitalbooking.backend.domain.expcetion.ImageNotFoundException;
import com.digitalbooking.backend.domain.model.Image;
import com.digitalbooking.backend.domain.model.Product;
import com.digitalbooking.backend.domain.repository.IImageRepository;
import com.digitalbooking.backend.domain.service.IImageService;
import com.digitalbooking.backend.infrastructure.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements IImageService {

    private final IImageRepository repository;

    @Override
    public Image save(Image image) {
        return image.isNew() ? create(image) : update(image);
    }

    @Override
    public Image findById(String id) {
        return repository.findById(id).orElseThrow( () -> new ImageNotFoundException(id));
    }

    @Override
    public Page<Image> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    private Image create(Image i) {
        Image image = repository.save(i);
        repository.flush();
        return image;
    }

    private Image update(Image i) {
        Image image = repository.save(i);
        repository.flush();
        return image;
    }
}
