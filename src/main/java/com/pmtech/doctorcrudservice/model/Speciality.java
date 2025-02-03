package com.pmtech.doctorcrudservice.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jakarta.validation.constraints.Size;

public class Speciality {

    @Size(max = 100, message = "Speciality name should not be more than 25 characters")
    private String specialityName;

    @Size(max = 500, message = "Speciality description should not be more than 200 characters")
    private String description;

    public Speciality() {
    }
    
    public Speciality(String name, String description) {
        this.specialityName = name;
        this.description = description;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

