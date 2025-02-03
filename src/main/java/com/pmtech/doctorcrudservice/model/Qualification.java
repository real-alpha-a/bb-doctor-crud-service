package com.pmtech.doctorcrudservice.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jakarta.validation.constraints.Size;
import java.util.Date;

public class Qualification {

    @Size(max = 100, message = "Degree name should not be more than 100 characters")
    private String degreeName;

    @Size(max = 100, message = "Institute name should not be more than 100 characters")
    private String instituteName;

    private Date passOutYear;

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public Date getPassOutYear() {
        return passOutYear;
    }

    public void setPassOutYear(Date passOutYear) {
        this.passOutYear = passOutYear;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
