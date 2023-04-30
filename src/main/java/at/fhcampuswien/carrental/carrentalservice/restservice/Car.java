package at.fhcampuswien.carrental.carrentalservice.restservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;


@Entity
//@Document(collection="user") //for mongoDB
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Model;
    private Date Year;
    private double Price;
    private boolean Automatic;
    private int Mileage;
    private String Fuel;
    private String Location;

   public Car(){}

    public Car( String model, Date year, double price, boolean automatic, int mileage, String fuel, String location) {
        //this.ID = ID;
        this.Model = model;
        this.Year = year;
        this.Price = price;
        this.Automatic = automatic;
        this.Mileage = mileage;
        this.Fuel = fuel;
        this.Location = location;
        /*
        Model = model;
        Year = year;
        Price = price;
        Automatic = automatic;
        Mileage = mileage;
        Fuel = fuel;
        Location = location;

         */
    }


    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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
