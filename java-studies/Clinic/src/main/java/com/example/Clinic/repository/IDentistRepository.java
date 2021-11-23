package com.example.Clinic.repository;

import com.example.Clinic.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDentistRepository implements JpaRepository<Dentist, Integer> {
}
