package at.fhcampuswien.carrental.carrentalservice.restservice;



import at.fhcampuswien.carrental.carrentalservice.entity.CarAttribute;
import at.fhcampuswien.carrental.carrentalservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class CarController {

    @Autowired
    private CarRepository repo;

    static List<CarAttribute> Cars = new ArrayList<CarAttribute>();

    @GetMapping("v1/Cars")
    List<CarAttribute> getCars() {
        return (List<CarAttribute>) repo.findAll();
    }

    @GetMapping("v1/Cars/{id}")
    CarAttribute getCar(@PathVariable int id){

        Optional<CarAttribute> optionalcar = repo.findById(id);

        if(!optionalcar.isPresent()){
            return null;
        }
        else{
            return optionalcar.get();
        }

    }

    @PostMapping("v1/Cars")
    String saveCar(@RequestBody List<CarAttribute> newCar) {

        if (!newCar.isEmpty()){
            repo.saveAll(newCar);
            return "Cars were saved";
        }


        return "No value found";
    }

//    @DeleteMapping("v1/Cars/{id}")
//    String deleteEmployee(@PathVariable(value = "id") int id) {
//
//        //TODO: car von der datenbank löschen
//        Cars.removeIf(car -> id==car.getID());
//        //repo.deleteCarBy(id);
//        repo.deleteAllById(id);
//        return "Car was deleted";
//    }

}
