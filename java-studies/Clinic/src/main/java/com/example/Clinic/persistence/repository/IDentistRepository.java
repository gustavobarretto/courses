package com.example.Clinic.persistence.repository;

import com.example.Clinic.persistence.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDentistRepository extends JpaRepository<Dentist, Integer> {
}
