package com.dh.app1av1.service.impl;

import com.dh.app1av1.entity.Catalog;
import com.dh.app1av1.feign.MovieFeign;
import com.dh.app1av1.repository.CatalogRepository;
import com.dh.app1av1.service.CatalogService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private MovieFeign feign;
    private CatalogRepository repository;

    @Override
    public List<Object> getByGenre(String genre) {
        return feign.findByGenre(genre);
    }

    @Override
    public Catalog create(Catalog catalog) {
        return repository.save(catalog);
    }
}
