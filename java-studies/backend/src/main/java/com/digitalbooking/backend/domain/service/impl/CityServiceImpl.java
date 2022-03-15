package com.digitalbooking.backend.domain.service.impl;

import com.digitalbooking.backend.domain.expcetion.CityNotFoundException;
import com.digitalbooking.backend.domain.model.Category;
import com.digitalbooking.backend.domain.model.City;
import com.digitalbooking.backend.domain.repository.ICityRepository;
import com.digitalbooking.backend.domain.service.ICityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityServiceImpl implements ICityService {

    private final ICityRepository repository;

    @Override
    public City save(City city) {
        return city.isNew() ? create(city) : update(city);
    }

    @Override
    public City findById(String id) {
        return repository.findById(id).orElseThrow( () -> new CityNotFoundException(id));
    }

    @Override
    public Page<City> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    private City create(City c) {
        City city = repository.save(c);
        repository.flush();
        return city;
    }

    private City update(City c) {
        City city = repository.save(c);
        repository.flush();
        return city;
    }


}
