package com.example.Clinic.persistence.repository;

import com.example.Clinic.persistence.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Integer> {
}
