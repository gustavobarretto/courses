package com.example.Clinic.controller;

import com.example.Clinic.persistence.entities.Dentist;
import com.example.Clinic.services.impl.DentistServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    @Autowired
    private DentistServiceImpl dentistService;

    private Logger logger = Logger.getLogger(DentistController.class);

    @PostMapping("/save")
    public ResponseEntity<Dentist> dentistSave(@RequestBody Dentist dentist) {
        logger.info("Saving dentist with name: " + dentist.getName());
        return ResponseEntity.ok(dentistService.save(dentist));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> searchDentist(@PathVariable Integer id) {
        logger.info("Saving dentist with id " + id);
        return ResponseEntity.ok(dentistService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Dentist>> searchAllDentists() {
        logger.info("Searching all the dentists");
        return ResponseEntity.ok(dentistService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDentist(@PathVariable Integer id) {
        logger.info("Deleting dentist with id " + id);
        dentistService.delete(id);
        return ResponseEntity.ok("Dentist deleted with success");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Dentist> updateDentist(@PathVariable Integer id, @RequestBody Dentist dentist) {
        logger.info("Updating dentist with id " + id);
        return ResponseEntity.ok(dentistService.update(id, dentist));
    }

}
