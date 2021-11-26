package com.example.Clinic.services.impl;

import com.example.Clinic.persistence.entities.Appointment;
import com.example.Clinic.persistence.entities.Dentist;
import com.example.Clinic.persistence.entities.Patient;
import com.example.Clinic.persistence.repository.IAppointmentRepository;
import com.example.Clinic.persistence.repository.IPatientRepository;
import com.example.Clinic.services.IClinicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements IClinicServices<Appointment> {

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Autowired
    private DentistServiceImpl dentistService;

    @Autowired
    private PatientServiceImpl patientService;

    @Override
    public Appointment save(Appointment appointment) {
        Dentist dentist = dentistService.findById(appointment.getPatient().getId());
        Patient patient = patientService.findById(appointment.getDentist().getId());
        appointment.setPatient(patient);
        appointment.setDentist(dentist);
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment findById(Integer id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        appointmentRepository.deleteById(id);

    }

    @Override
    public Appointment update(Integer id, Appointment appointment) {
        Appointment appointmentToBeUpdated = appointmentRepository.findById(id).get();

        if(appointment.getPatient() != null)
            appointmentToBeUpdated.setPatient(patientService.findById(appointment.getPatient().getId()));
        if(appointment.getDentist() != null)
            appointmentToBeUpdated.setDentist(dentistService.findById(appointment.getDentist().getId()));
        return appointmentRepository.saveAndFlush(appointmentToBeUpdated);
    }
}
