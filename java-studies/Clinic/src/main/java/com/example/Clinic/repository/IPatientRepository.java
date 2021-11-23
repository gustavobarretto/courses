package com.example.Clinic.repository;

import com.example.Clinic.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {
}
