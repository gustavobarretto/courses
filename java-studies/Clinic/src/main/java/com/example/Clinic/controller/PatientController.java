package com.example.Clinic.controller;

import com.example.Clinic.persistence.entities.Patient;
import com.example.Clinic.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping("/add")
    public ResponseEntity<Patient> savePatient(Patient patient){
        return ResponseEntity.ok(patientService.save(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Integer id){
        return ResponseEntity.ok(patientService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients(){
        return ResponseEntity.ok(patientService.searchAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Integer id) {
        patientService.delete(id);
        Patient patient = patientService.findById(id);
        if(patient == null)
            return ResponseEntity.ok("Patient deleted");
        return ResponseEntity.ok("Patient was not deleted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer id, @RequestBody Patient patient){
        return ResponseEntity.ok(patientService.update(id, patient));
    }
}

