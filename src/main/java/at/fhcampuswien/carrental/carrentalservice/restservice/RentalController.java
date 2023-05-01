package at.fhcampuswien.carrental.carrentalservice.restservice;

import at.fhcampuswien.carrental.carrentalservice.entity.RentalAttribute;
import at.fhcampuswien.carrental.carrentalservice.repository.RentalRepository;
import at.fhcampuswien.carrental.carrentalservice.services.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RentalController {

    @Autowired
    RentalRepository repo;

    CurrencyConverter currencyConverter = new CurrencyConverter();

    @GetMapping("v1/rentals")
    List<RentalAttribute> getRentals(@RequestParam(defaultValue = "USD") String currency) {
        return convertCurrency(currency, repo.findAll());
}

    @PostMapping("v1/rentals")
    String createRental(@RequestBody RentalAttribute newRental) {

        if(!repo.findByCarId(newRental.getCarId()).isEmpty()) {
            RentalAttribute newRentalID = new RentalAttribute();
            newRental.setId(newRentalID.getId());
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
    List<RentalAttribute> getRentalDetails(@PathVariable int CustomerId, @RequestParam(defaultValue = "USD") String currency) {
        return convertCurrency(currency, repo.findByCustomerId(CustomerId));
    }

    @DeleteMapping("v1/rentals/{id}")
    String deleteRental(@PathVariable int RentalId) {
        repo.deleteById(RentalId);
        return "Rental was deleted";
    }

    private List<RentalAttribute> convertCurrency(String currency, Iterable<RentalAttribute> rentalAttributes){
        List<RentalAttribute> rentalList = new ArrayList<>();
        for (RentalAttribute rentalAttribute : rentalAttributes) {
            rentalAttribute.setTotalCost(currencyConverter.convertCurrency(currency, rentalAttribute.getTotalCost()));
            rentalList.add(rentalAttribute);
        }

        if (rentalList.isEmpty()){
            return null;
        }
        return rentalList;
    }


}
