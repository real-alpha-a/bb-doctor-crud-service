package com.pmtech.doctorcrudservice.repository;

import com.pmtech.doctorcrudservice.model.Doctor;

import java.util.List;

public interface CustomDoctorRepository {
    List<Doctor> findDoctorByFirstNameOrLastName(String name);
}
