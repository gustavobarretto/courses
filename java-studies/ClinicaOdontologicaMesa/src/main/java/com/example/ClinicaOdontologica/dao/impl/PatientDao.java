package com.example.ClinicaOdontologica.dao.impl;

import com.example.ClinicaOdontologica.dao.IDao;
import com.example.ClinicaOdontologica.dao.cfg.cfgJDBC;
import com.example.ClinicaOdontologica.model.Patient;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class PatientDao implements IDao<Patient> {

    Logger log = Logger.getLogger(PatientDao.class);
    private com.example.ClinicaOdontologica.dao.cfg.cfgJDBC cfgJDBC;

    @Override
    public Patient save(Patient patient) {
        Connection connection = cfgJDBC.database_connection();
        Statement statement = null;
        String


        return null;
    }

    @Override
    public List<Patient> searchAll() {
        return null;
    }

    @Override
    public Patient read(String email) {
        return null;
    }
}
