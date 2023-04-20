package at.fhcampuswien.carrental.carrentalservice.restservice;

import java.util.Date;

public class Customer {

    private String PassportNumber;
    private String Name;
    private Date Birthday;
    private String Address;
    private String PaymentMethod;
    private String Email;
    private String Password;

    public Customer(String passportNumber, String name, Date birthday, String address, String paymentMethod, String email, String password) {
        PassportNumber = passportNumber;
        Name = name;
        Birthday = birthday;
        Address = address;
        PaymentMethod = paymentMethod;
        Email = email;
        Password = password;
    }


    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }



}
