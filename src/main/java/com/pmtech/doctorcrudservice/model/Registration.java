package com.pmtech.doctorcrudservice.model;

public class Registration {

    private String mciRegNumber;
    private String stateRegNumber;

    public Registration() {
    }

    public Registration(String mciRegNumber, String stateRegNumber) {
        this.mciRegNumber = mciRegNumber;
        this.stateRegNumber = stateRegNumber;
    }

    public String getMciRegNumber() {
        return mciRegNumber;
    }

    public void setMciRegNumber(String mciRegNumber) {
        this.mciRegNumber = mciRegNumber;
    }

    public String getStateRegNumber() {
        return stateRegNumber;
    }

    public void setStateRegNumber(String stateRegNumber) {
        this.stateRegNumber = stateRegNumber;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "mciRegNumber='" + mciRegNumber + '\'' +
                ", stateRegNumber='" + stateRegNumber + '\'' +
                '}';
    }
}
