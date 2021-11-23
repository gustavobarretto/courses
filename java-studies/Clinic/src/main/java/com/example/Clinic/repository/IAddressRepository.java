package com.example.Clinic.repository;

import com.example.Clinic.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Integer> {
}
