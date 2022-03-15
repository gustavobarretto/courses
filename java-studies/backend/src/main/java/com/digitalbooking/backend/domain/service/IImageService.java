package com.digitalbooking.backend.domain.service;

import com.digitalbooking.backend.domain.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IImageService {

    Image save(Image image);
    Image findById(String id);
    Page<Image> findAll(Pageable pageable);
    void delete(String id);
}
