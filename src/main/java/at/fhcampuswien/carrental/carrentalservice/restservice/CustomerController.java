package at.fhcampuswien.carrental.carrentalservice.restservice;


import at.fhcampuswien.carrental.carrentalservice.entity.CustomerAttribute;
import at.fhcampuswien.carrental.carrentalservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerRepository repo;
    static List<Session> Sessions = new ArrayList<>();
    static int lastSessionId =0;


    @GetMapping("v1/Customers")
    List<CustomerAttribute> getCustomers() {
        return (List<CustomerAttribute>) repo.findAll();
    }

    @GetMapping("v1/Customers/login")
    Session getCustomer(@RequestParam String email, @RequestParam String passwordHash) {

        CustomerAttribute Customer = repo.findByEmail(email).get(0);

        if(Objects.equals(Customer.getPassword(), passwordHash)) {

            Session newSession = new Session(lastSessionId, email);
            Sessions.add(newSession);
            lastSessionId++;

            return newSession;

        }
        else{
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
    String registerCustomer(@RequestBody CustomerAttribute newCustomer) {
        if(repo.findByEmail(newCustomer.getEmail()).isEmpty()) {
            CustomerAttribute newCustomerID = new CustomerAttribute();
            newCustomer.setId(newCustomerID.getId());
            repo.save(newCustomer);

            return "Customer was registered";
        }

        else{
            return "email already registered";
        }
    }

//TODO Change User attributes later on

//    @PutMapping("v1/Customers/{sessionID}")
//    String editCustomer(@PathVariable int sessionID,@RequestBody Customer editedCustomer){
//
//        if (null==Sessions.stream().filter(session -> sessionID==session.getSessionID()).findAny().orElse(null))
//        {
//            //TODO:Customer wird in der Datenbank erstezt/Attribute verändert
//            return "User info has been changed";
//        }
//        else
//        {
//            return "no session under that id";
//        }
//
//    }

//    @GetMapping("v1/Customers/{sessionID}")
//    Customer getCustomerDetails(@PathVariable Integer sessionID){
//
//        Session currentSession =Sessions.stream().filter(session -> sessionID==session.getSessionID()).findAny().orElse(null);
//
//        if (Sessions.contains(currentSession))
//        {
//            //TODO: Customer von der Datenbank holen
//            return Customers.stream().filter(customer -> currentSession.getAccountMail() == customer.getEmail()).findAny().orElse(null);
//        }
//        else
//        {
//            return null;
//        }
//
//    }

//    @DeleteMapping("v1/Customers/{sessionID}")
//    String deleteCustomer(@PathVariable int sessionID,@RequestBody Customer editedCustomer){
//
//        Session currentSession =Sessions.stream().filter(session -> sessionID==session.getSessionID()).findAny().orElse(null);
//
//        if (null==currentSession)
//        {
//            //TODO:Customer wird von der Datenbank gelöscht
//            Customers.removeIf(Customer -> currentSession.getAccountMail()==Customer.getEmail());
//            return "Account has been deleted";
//        }
//        else
//        {
//            return "no session under that id";
//        }
//
//    }

}
