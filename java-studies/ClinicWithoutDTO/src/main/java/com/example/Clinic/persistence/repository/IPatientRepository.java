package com.example.Clinic.persistence.repository;

import com.example.Clinic.persistence.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {
}
