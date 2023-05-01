package at.fhcampuswien.carrental.carrentalservice.restservice;



import at.fhcampuswien.carrental.carrentalservice.entity.CarAttribute;
import at.fhcampuswien.carrental.carrentalservice.repository.CarRepository;
import at.fhcampuswien.carrental.carrentalservice.services.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class CarController {

    @Autowired
    private CarRepository repo;

    CurrencyConverter currencyConverter = new CurrencyConverter();

    @GetMapping("v1/Cars")
    List<CarAttribute> getCars(@RequestParam(defaultValue = "USD") String currency) {
        return convertCurrency(currency,repo.findAll());
    }

    @GetMapping("v1/Cars/{id}")
    CarAttribute getCar(@PathVariable int id){

        Optional<CarAttribute> optionalCar = repo.findById(id);

        return optionalCar.orElse(null);

    }

    @PostMapping("v1/Cars")
    String saveCar(@RequestBody List<CarAttribute> newCar) {

        if (!newCar.isEmpty()){
            repo.saveAll(newCar);
            return "Cars were saved";
        }


        return "No value found";
    }

    private List<CarAttribute> convertCurrency(String currency, Iterable<CarAttribute> carAttributes){
        List<CarAttribute> carList = new ArrayList<>();
        for (CarAttribute carAttribute : carAttributes) {
            carAttribute.setPriceusd(currencyConverter.convertCurrency(currency, carAttribute.getPriceusd()));
            carList.add(carAttribute);
        }

        if (carList.isEmpty()){
            return null;
        }
        return carList;
    }

}
