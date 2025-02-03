package com.pmtech.doctorcrudservice.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class EmailAddress {

    @Email(message = "Please enter a valid email address")
    @Size(max = 50, message = "Email should not be more than 25 characters")
    private String emailAddress;
    private Boolean isVerified;

    public EmailAddress(String emailAddress, Boolean isVerified) {
        this.emailAddress = emailAddress;
        this.isVerified = isVerified;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
                "emailAddress='" + emailAddress + '\'' +
                ", isVerified=" + isVerified +
                '}';
    }
}