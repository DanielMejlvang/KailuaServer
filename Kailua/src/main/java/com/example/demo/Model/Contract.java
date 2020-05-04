package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contract {
    @Id
    private int contractID;
    private int renterID;
    private int carID;
    private String toDate;
    private String fromDate;
    private int maxKM;

    public Contract() {
    }

    public Contract(int contractID, int renterID, int carID, String toDate, String fromDate, int maxKM) {
        this.contractID = contractID;
        this.renterID = renterID;
        this.carID = carID;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.maxKM = maxKM;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getRenterID() {
        return renterID;
    }

    public void setRenterID(int renterID) {
        this.renterID = renterID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public int getMaxKM() {
        return maxKM;
    }

    public void setMaxKM(int maxKM) {
        this.maxKM = maxKM;
    }
}
