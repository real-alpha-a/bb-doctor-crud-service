package com.pmtech.doctorcrudservice.service;

import com.pmtech.doctorcrudservice.model.Doctor;
import com.pmtech.doctorcrudservice.repository.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;

@Service
public class DoctorCrudServiceImpl implements IDoctorCrudService {

    Logger logger = LoggerFactory.getLogger(DoctorCrudServiceImpl.class);

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Doctor save(final Doctor doctor){
        Doctor doc =  doctorRepository.save(doctor);

        if(doc != null)
            logger.info("doctor saved successfully.");
        else
            logger.error("unable to save doctor");

        return doc;
    }

    @Override
    public Optional<Doctor> fetchById(String doctorId){
        return doctorRepository.findById(doctorId);
    }

    @Override
    public List<Doctor> findAll() {

        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> findByFirstNameOrLastName(String searchValue) {

        if (!hasText(searchValue)) {
            return null;
        }


        return doctorRepository.findDoctorByFirstNameOrLastName(searchValue);
    }

    @Override
    public void deleteById(String doctorId){

        doctorRepository.deleteById(doctorId);
    }

    @Override
    public Long getCount() {

        return doctorRepository.count();
    }
}