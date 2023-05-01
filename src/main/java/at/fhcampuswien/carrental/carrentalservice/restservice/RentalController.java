package at.fhcampuswien.carrental.carrentalservice.restservice;

import at.fhcampuswien.carrental.carrentalservice.entity.RentalAttribute;
import at.fhcampuswien.carrental.carrentalservice.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RentalController {

    @Autowired
    RentalRepository repo;

    @GetMapping("v1/rentals")
    List<RentalAttribute> getRentals() {
    return (List<RentalAttribute>) repo.findAll();
}

    @PostMapping("v1/rentals")
    String createRental(@RequestBody RentalAttribute newRental) {
        //TODO: rental wird in die DB hinzugefügt

        if(!repo.findByCarId(newRental.getCarId()).isEmpty()) {

            repo.save(newRental);

            return "Rental was created";
        }
        else{

            return "Car is already rented";

        }

    }

//    @PutMapping("v1/rentals/{id}")
//    String editRental(@PathVariable int RentalId) {
//        //TODO: rental wird in der DB ersetzt oder Attribute verändert
//        return "Rental information was edited";
//    }

    @GetMapping("v1/rentals/{id}")
    List<RentalAttribute> getRentalDetails(@PathVariable int CustomerId) {
        return repo.findByCustomerId(CustomerId);
    }

    @DeleteMapping("v1/rentals/{id}")
    String deleteRental(@PathVariable int RentalId) {
        repo.deleteById(RentalId);
        return "Rental was deleted";
    }


}
