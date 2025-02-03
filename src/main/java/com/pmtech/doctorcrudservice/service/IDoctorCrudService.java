package com.pmtech.doctorcrudservice.service;

import com.pmtech.doctorcrudservice.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface IDoctorCrudService {

     Doctor save(Doctor doctor);
     Optional<Doctor> fetchById(String doctorId);
     List<Doctor> findAll();
     List<Doctor> findByFirstNameOrLastName(String name);
     void deleteById(String doctorId);
     Long getCount();
}