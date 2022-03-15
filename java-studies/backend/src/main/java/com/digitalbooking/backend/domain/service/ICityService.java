package com.digitalbooking.backend.domain.service;

import com.digitalbooking.backend.domain.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService {

    City save(City city);
    City findById(String id);
    Page<City> findAll(Pageable pageable);
    void delete(String id);
}
