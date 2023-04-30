package at.fhcampuswien.carrental.carrentalservice.restservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RentalController {

    static List<Rental> Rentals = new ArrayList<>();

    static int lastRentalId =0;

//    @GetMapping("v1/rentals")
//    List<Rental> getRental() {
//        //TODO: alle rentals werden von der Datenbank geholt
//        return Rentals;
//    }
    @PostMapping("v1/rentals")
    String createRental(@RequestBody Rental newRental) {
        //TODO: rental wird in die DB hinzugefügt
        return "Rental was created";
    }

//    @PutMapping("v1/rentals/{id}")
//    String editRental(@PathVariable int RentalId) {
//        //TODO: rental wird in der DB ersetzt oder Attribute verändert
//        return "Rental information was edited";
//    }

    @GetMapping("v1/rentals/{id}")
    Rental getRentalDetails(@PathVariable int CustomerId) {
        //TODO: All rentals for the user will be fetched from DB
        return null;
    }

    @DeleteMapping("v1/rentals/{id}")
    String deleteRental(@PathVariable int RentalId) {
        //TODO: rental wird in der DB ersetzt oder Attribute verändert
        return "Rental was deleted";
    }

}
