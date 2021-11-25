package com.example.Clinic.controller;

import com.example.Clinic.persistence.entities.Appointment;
import com.example.Clinic.services.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @PostMapping("/save")
    private ResponseEntity<Appointment> appointmentSave(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> searchAppointment(@PathVariable Integer id) {
        return ResponseEntity.ok(appointmentService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> searchAllAppointments() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Integer id) {
        appointmentService.delete(id);
        Appointment appointment = appointmentService.findById(id);
        if(appointment != null)
            return ResponseEntity.internalServerError().body("Appointment not deleted");
        return ResponseEntity.ok("Patient deleted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Integer id, @RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.update(id, appointment));
    }
}
