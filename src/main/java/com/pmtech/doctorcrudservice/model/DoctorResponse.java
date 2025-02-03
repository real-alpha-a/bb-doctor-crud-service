package com.pmtech.doctorcrudservice.model;

public class DoctorResponse {
    private Doctor doctor;

    public DoctorResponse(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
