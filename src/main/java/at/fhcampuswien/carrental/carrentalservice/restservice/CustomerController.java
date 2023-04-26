package at.fhcampuswien.carrental.carrentalservice.restservice;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;



@RestController
public class CustomerController {

    static List<Session> Sessions = new ArrayList<>();
    static List<Customer> Customers = new ArrayList<>();
    static int lastCustomerId =0;
    static int lastSessionId =0;

    @PostMapping("v1/Customers/register")
    String getCustomers(@RequestBody Customer newCustomer)
    {
        lastCustomerId = lastCustomerId+1;

        //Customer CustomertoAdd = new Customer(lastCustomerid,Model,Year,Price,Automatic,Mileage,Fuel,InitialLocation);

        Customers.add(newCustomer);

        return "Customer was registered";
    }


    //TODO:was bedeutet (Control afterwards)?
    @GetMapping("v1/Customers/login")
    Session getCustomer(@RequestBody List<String> credentials) {
        if (null!=Customers.stream().filter(customer -> credentials.get(0)==customer.getEmail() & credentials.get(1)==customer.getPassword()).findAny().orElse(null))
        {
            lastSessionId = lastSessionId +1;
            Session newSession = new Session(lastSessionId,credentials.get(0));
            Sessions.add(newSession);
            return newSession;
        }
        else
        {
            return null;
        }
    }
    @GetMapping("v1/Customers/logout")
    String deleteSession(@RequestBody Integer session) {
        if (Sessions.contains(session))
        {
            Sessions.remove(session);
            return "User has been logged out";
        }
        else
        {
            return "no session under that id";
        }
    }
    @PostMapping("v1/Customers/register")
    String registerCustomer(@RequestBody Customer newCustomer) {

        if(null==Customers.stream().filter(customer -> newCustomer.getEmail()==customer.getEmail()).findAny().orElse(null)) {

            lastCustomerId = lastCustomerId + 1;

            //Customer CustomertoAdd = new Customer(lastCustomerid,Model,Year,Price,Automatic,Mileage,Fuel,InitialLocation);

            Customers.add(newCustomer);

            return "Customer was registered";
        }
        else{
            return "email already registered";
        }
    }

    @PutMapping("v1/Customers/{sessionID}")
    String editCustomer(@PathVariable int sessionID,@RequestBody Customer editedCustomer){

        if (null==Sessions.stream().filter(session -> sessionID==session.getSessionID()).findAny().orElse(null))
        {
            //TODO:Customer wird in der Datenbank erstezt/Attribute verändert
            return "User info has been changed";
        }
        else
        {
            return "no session under that id";
        }

    }

    @GetMapping("v1/Customers/{sessionID}")
    Customer getCustomerDetails(@PathVariable Integer sessionID){

        Session currentSession =Sessions.stream().filter(session -> sessionID==session.getSessionID()).findAny().orElse(null);

        if (Sessions.contains(currentSession))
        {
            //TODO: Customer von der Datenbank holen
            return Customers.stream().filter(customer -> currentSession.getAccountMail() == customer.getEmail()).findAny().orElse(null);
        }
        else
        {
            return null;
        }

    }

    @DeleteMapping("v1/Customers/{sessionID}")
    String deleteCustomer(@PathVariable int sessionID,@RequestBody Customer editedCustomer){

        Session currentSession =Sessions.stream().filter(session -> sessionID==session.getSessionID()).findAny().orElse(null);

        if (null==currentSession)
        {
            //TODO:Customer wird von der Datenbank gelöscht
            Customers.removeIf(Customer -> currentSession.getAccountMail()==Customer.getEmail());
            return "Account has been deleted";
        }
        else
        {
            return "no session under that id";
        }

    }

}
