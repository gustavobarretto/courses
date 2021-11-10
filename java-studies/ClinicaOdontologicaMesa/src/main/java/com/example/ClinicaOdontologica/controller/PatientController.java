package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.model.Patient;
import com.example.ClinicaOdontologica.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {
    private final PatientServiceImpl patientService;

    @Autowired
    public PatientController(PatientServiceImpl patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/search")
    public String search(Model model) {
        Patient patient = patientService.search("sa");
        model.addAttribute("name", patient.getName());
        model.addAttribute("surname", patient.getSurname());
        return "index";
    }
}
