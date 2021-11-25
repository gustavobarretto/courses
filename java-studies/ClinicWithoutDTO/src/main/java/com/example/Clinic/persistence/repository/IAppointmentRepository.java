package com.example.Clinic.persistence.repository;

import com.example.Clinic.persistence.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
}
