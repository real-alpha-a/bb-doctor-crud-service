package com.pmtech.doctorcrudservice.controller;

import com.pmtech.doctorcrudservice.constants.MessageKey;
import com.pmtech.doctorcrudservice.exception.DoctorNotFoundException;
import com.pmtech.doctorcrudservice.model.Doctor;
import com.pmtech.doctorcrudservice.service.IDoctorCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("api/v1/doctors")
public class DoctorCrudController {

    Logger logger = LoggerFactory.getLogger(DoctorCrudController.class);

    @Autowired
    MessageSource messageSource;

    @Autowired
    private IDoctorCrudService doctorCrudService;

    @PostMapping("")
    public ResponseEntity<String> createDoctor(@Valid @RequestBody Doctor doctor) {
        logger.info("Creating new doctor with data: " + doctor);
        doctorCrudService.save(doctor);

        return new ResponseEntity<>(
                messageSource.getMessage(MessageKey.DR_CREATE_SUCCESS, new String[] {},
                        LocaleContextHolder.getLocale()),
                HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@Valid @RequestBody Doctor doctor) {
        logger.info("Updating doctor id: " + doctor.getDoctorId() + "with data " + doctor);

        if (doctor.getDoctorId() == null || doctor.getDoctorId().trim().length() == 0) {
            logger.error("Unable to update doctor, missing mandatory field : doctorId");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("doctorId is required");
        }

        Doctor fetchedDoctor = doctorCrudService.fetchById(doctor.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException(
                        messageSource.getMessage(MessageKey.DR_RECORD_NOT_FOUND, new String[] { doctor.getDoctorId() },
                                LocaleContextHolder.getLocale())));

        if (doctor.getCreatedAt() == null) {
            doctor.setCreatedAt(fetchedDoctor.getCreatedAt());
        }

        return new ResponseEntity<>(doctorCrudService.save(doctor), HttpStatus.OK);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<?> retrieve(@PathVariable String doctorId) {
        logger.info("Fetching doctor for id: " + doctorId);

        if (doctorId == null || doctorId.trim().length() == 0) {
            logger.error("Unable to retrieve doctor, missing mandatory field : doctorId");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("doctorId is required");
        }

        Doctor doctor = doctorCrudService.fetchById(doctorId).orElseThrow(() -> new DoctorNotFoundException(
                messageSource.getMessage(MessageKey.DR_RECORD_NOT_FOUND, new String[] { doctorId },
                        LocaleContextHolder.getLocale())));

        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<?> delete(@PathVariable String doctorId) {
        logger.debug("Deleting doctor for id: " + doctorId);

        if (doctorId == null || doctorId.trim().length() == 0) {
            logger.error("Unable to delete doctor, missing mandatory field : doctorId");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("doctorId is required");
        }

        doctorCrudService.fetchById(doctorId).orElseThrow(() -> new DoctorNotFoundException(
                messageSource.getMessage(MessageKey.DR_RECORD_NOT_FOUND, new String[] { doctorId },
                        LocaleContextHolder.getLocale())));

        doctorCrudService.deleteById(doctorId);

        return new ResponseEntity<>(messageSource.getMessage(MessageKey.DR_DELETE_SUCCESS, new String[] { doctorId },
                LocaleContextHolder.getLocale()), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<?> findDoctorByName(@RequestParam @NotBlank String doctorName) {
        logger.debug("Fetching all doctors with name: " + doctorName);
        return ResponseEntity.status(HttpStatus.OK).body(doctorCrudService.findByFirstNameOrLastName(doctorName));
    }
}
