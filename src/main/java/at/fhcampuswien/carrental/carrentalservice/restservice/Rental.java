package at.fhcampuswien.carrental.carrentalservice.restservice;

import java.util.Date;

public class Rental {

    private String RentalID;
    private String Car;
    private boolean Rented;
    private String Customer;
    private Date RentalDate;
    private Date ReturnDate;

    public Rental(String rentalID, String car, boolean rented, String customer, Date rentalDate, Date returnDate) {
        RentalID = rentalID;
        Car = car;
        Rented = rented;
        Customer = customer;
        RentalDate = rentalDate;
        ReturnDate = returnDate;
    }

    public String getRentalID() {
        return RentalID;
    }

    public void setRentalID(String rentalID) {
        RentalID = rentalID;
    }

    public String getCar() {
        return Car;
    }

    public void setCar(String car) {
        Car = car;
    }

    public boolean isRented() {
        return Rented;
    }

    public void setRented(boolean rented) {
        Rented = rented;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public Date getRentalDate() {
        return RentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        RentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date returnDate) {
        ReturnDate = returnDate;
    }


}
