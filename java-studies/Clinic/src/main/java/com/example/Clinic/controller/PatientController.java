package com.example.Clinic.controller;

import com.example.Clinic.persistence.entities.Patient;
import com.example.Clinic.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping("/add")
    public ResponseEntity<Patient> savePatient(Patient patient){
        return ResponseEntity.ok(patientService.save(patient));
    }

    @GetMapping("/{id")
}

