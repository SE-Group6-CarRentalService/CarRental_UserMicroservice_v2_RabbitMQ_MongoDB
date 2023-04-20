package at.fhcampuswien.carrental.carrentalservice.restservice;

import java.util.Date;


public class Car{

    private int ID;
    private String Model;
    private Date Year;
    private double Price;
    private boolean Automatic;
    private int Mileage;
    private String Fuel;
    private String Location;

    public Car(int ID, String model, Date year, double price, boolean automatic, int mileage, String fuel, String location) {
        this.ID = ID;
        Model = model;
        Year = year;
        Price = price;
        Automatic = automatic;
        Mileage = mileage;
        Fuel = fuel;
        Location = location;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Date getYear() {
        return Year;
    }

    public void setYear(Date year) {
        Year = year;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public boolean isAutomatic() {
        return Automatic;
    }

    public void setAutomatic(boolean automatic) {
        Automatic = automatic;
    }

    public int getMileage() {
        return Mileage;
    }

    public void setMileage(int mileage) {
        Mileage = mileage;
    }

    public String getFuel() { return Fuel; }

    public void setFuel(String fuel) {
        Fuel = fuel;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }




}
