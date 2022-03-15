package com.digitalbooking.backend.domain.repository;

import com.digitalbooking.backend.domain.model.City;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City, String> {
    City findyByName(String name);
}
