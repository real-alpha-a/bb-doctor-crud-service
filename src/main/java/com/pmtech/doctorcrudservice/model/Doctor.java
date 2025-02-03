package com.pmtech.doctorcrudservice.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@PropertySource("classpath:messages.properties")
@Document("doctors")
public class Doctor {

    @Id
    private String doctorId;
    private String initial;

    @NotEmpty(message = "Please enter a valid firstName")
    @Size(max = 20,message = "firstName should not be more than 20 characters")
    private String firstName;

    @NotEmpty(message = "Please enter a valid lastName")
    @Size(max = 20,message = "lastName should not be more than 20 characters")
    private String lastName;

    @Valid
    Registration registration;

    @Valid
    private List<Speciality> specialities;

    @Valid
    private List<Qualification> qualifications;

    @Valid
    private Address address;

    @Valid
    private List<EmailAddress> emailAddresses;

    private List<Phone> phoneNumbers;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date lastUpdatedOn;

    public Doctor() {
    }

    public Doctor(String doctorId, String initial, @NotEmpty(message = "Please enter a valid firstName") @Size(max = 20, message = "firstName should not exceed 20 charecters") String firstName, @NotEmpty(message = "Please enter a valid lastName") @Size(max = 20, message = "lastName should not exceed 20 charecters") String lastName, List<Speciality> specialities, List<Qualification> qualifications, Address address, List<EmailAddress> emailAddresses, List<Phone> phoneNumbers, Date createdAt, Date lastUpdatedOn) {
        this.doctorId = doctorId;
        this.initial = initial;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialities = specialities;
        this.qualifications = qualifications;
        this.address = address;
        this.emailAddresses = emailAddresses;
        this.phoneNumbers = phoneNumbers;
        this.createdAt = createdAt;
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<EmailAddress> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Date lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
