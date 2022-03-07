package com.ctd.model;

import java.util.Date;
import java.util.Objects;

public class AirPlane {

    private int id;
    private String brand;
    private String model;
    private int registration;
    private Date DateEntryIntoservice;

    public AirPlane() {
    }

    public AirPlane(int id, String brand, String model, int registration, Date dateEntryIntoservice) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.registration = registration;
        DateEntryIntoservice = dateEntryIntoservice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }

    public Date getDateEntryIntoservice() {
        return DateEntryIntoservice;
    }

    public void setDateEntryIntoservice(Date dateEntryIntoservice) {
        DateEntryIntoservice = dateEntryIntoservice;
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", registration=" + registration +
                ", DateEntryIntoservice=" + DateEntryIntoservice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirPlane airPlane = (AirPlane) o;
        return id == airPlane.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
