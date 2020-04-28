package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    private int carID;
    private String carType;
    private String carBrand;
    private String carModel;
    private String licenseplate;
    private String registrationDate;
    private int odometer;

    public Car() {
    }

    public Car(int carID, String carType, String carBrand, String carModel, String licenseplate, String registrationDate, int odometer) {
        this.carID = carID;
        this.carType = carType;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.licenseplate = licenseplate;
        this.registrationDate = registrationDate;
        this.odometer = odometer;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int id) {
        this.carID = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String type) {
        this.carType = type;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String brand) {
        this.carBrand = brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String model) {
        this.carModel = model;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationplate) {
        this.registrationDate = registrationplate;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
