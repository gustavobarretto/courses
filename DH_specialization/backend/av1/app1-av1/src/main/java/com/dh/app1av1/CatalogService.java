package com.dh.app1av1;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogService {

    private final MovieFeign service;

    public List<Object> getByGenre(String genre) {
        System.out.println("AQUI:");
        System.out.println(service.findByGenre(genre));
        return service.findByGenre(genre);
    }

}