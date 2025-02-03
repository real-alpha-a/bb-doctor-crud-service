package com.pmtech.doctorcrudservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Document(collection = "Phones")
public class Phone {
    @NotEmpty(message = "Please enter a phone number")
    @Size(max = 10,message = "Phone number can not exceed 10 digits")
    private String phone;
    private PhoneType phoneType;
    private String countryCode;
    private Boolean isVerified;

    public Phone() {
        this.isVerified = false;
    }

    public Phone(@NotEmpty(message = "Please enter a phone number") @Size(max = 10, message = "Phone number can not exceed 10 digits") String phone, PhoneType phoneType, String countryCode, Boolean isVerified) {
        this.phone = phone;
        this.phoneType = phoneType;
        this.countryCode = countryCode;
        this.isVerified = isVerified;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phone='" + phone + '\'' +
                ", phoneType=" + phoneType +
                ", countryCode='" + countryCode + '\'' +
                ", isVerified=" + isVerified +
                '}';
    }
}