package com.digitalbooking.backend.domain.repository;

import com.digitalbooking.backend.domain.model.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharacteristicRepository extends JpaRepository<Characteristic, String> {

    Characteristic findByName(String name);
}
