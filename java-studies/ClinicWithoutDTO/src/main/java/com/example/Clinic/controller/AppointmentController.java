package com.example.Clinic.controller;

import com.example.Clinic.persistence.entities.Appointment;
import com.example.Clinic.services.impl.AppointmentServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    private Logger logger = Logger.getLogger(AppointmentController.class);

    @PostMapping("/save")
    private ResponseEntity<Appointment> appointmentSave(@RequestBody Appointment appointment) {
        logger.info("Saving appointment with patient with id " + appointment.getPatient().getId() + " and dentist with id " + appointment.getDentist().getId());
        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> searchAppointment(@PathVariable Integer id) {
        logger.info("Searching appointment with id " + id);
        return ResponseEntity.ok(appointmentService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> searchAllAppointments() {
        logger.info("Searching all apointments.");
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Integer id) {
        logger.info("Deleting appointment with id " + id);
        appointmentService.delete(id);
        return ResponseEntity.ok("Patient deleted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Integer id, @RequestBody Appointment appointment) {
        logger.info("Updating appointment with id " + id);
        return ResponseEntity.ok(appointmentService.update(id, appointment));
    }
}
