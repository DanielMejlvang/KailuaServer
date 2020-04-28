package com.example.demo.Model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Renter {
     @Id
     private int renterID;
     private String firstname;
     private String lastname;
     private String mobile;
     private String phone;
     private String street;
     private String zip;
     private String email;
     private String licenseNumber;
     private String driverSinceDate;

    public Renter() {
    }

    public Renter(int renterID, String firstname, String lastname, String mobile, String phone, String street, String zip, String email, String licenseNumber, String driverSinceDate) {
        this.renterID = renterID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
        this.phone = phone;
        this.street = street;
        this.zip = zip;
        this.email = email;
        this.licenseNumber = licenseNumber;
        this.driverSinceDate = driverSinceDate;
    }

    public int getRenterID() {
        return renterID;
    }

    public void setRenterID(int renterID) {
        this.renterID = renterID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getDriverSinceDate() {
        return driverSinceDate;
    }

    public void setDriverSinceDate(String driverSinceDate) {
        this.driverSinceDate = driverSinceDate;
    }
}
