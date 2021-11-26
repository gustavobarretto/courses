package com.example.Clinic.controller;

import com.example.Clinic.persistence.entities.Patient;
import com.example.Clinic.services.impl.PatientServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    private Logger logger = Logger.getLogger(PatientController.class);

    @PostMapping("/save")
    public ResponseEntity<Patient> patientSave(@RequestBody Patient patient) {
        logger.info("Saving patient with name: " + patient.getName());
        return ResponseEntity.ok(patientService.save(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> searchPatient(@PathVariable Integer id) {
        logger.info("Searching patient with id " + id);
        return ResponseEntity.ok(patientService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> searchAllPatients() {
        logger.info("Searching all the patients");
        return ResponseEntity.ok(patientService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePatient(@PathVariable Integer id) {
        logger.info("Deleting patient with id " + id);
        patientService.delete(id);
        return ResponseEntity.ok("Patient deleted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer id, @RequestBody Patient patient) {
        logger.info("Updating patient with id " + id);
        return ResponseEntity.ok(patientService.update(id, patient));
    }
}
