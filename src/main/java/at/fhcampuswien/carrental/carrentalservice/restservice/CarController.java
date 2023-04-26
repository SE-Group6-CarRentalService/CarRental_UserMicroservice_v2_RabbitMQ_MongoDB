package at.fhcampuswien.carrental.carrentalservice.restservice;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class CarController {

    static List<Car> Cars = new ArrayList<>();

    static int lastCarid=0;

    static int lastRentalId =0;

    @GetMapping("v1/Cars")
    List<Car> getCars() {
        return Cars;
    }

    @GetMapping("v1/Cars/{id}")
    Car getCar(@PathVariable int id)
    {
        return Cars.stream().filter(car -> id==car.getID()).findAny().orElse(null);
    }

    @PostMapping("v1/Cars")
    String saveCar(@RequestBody Car newCar) {

        lastCarid = lastCarid+1;

        //Car CartoAdd = new Car(lastCarid,Model,Year,Price,Automatic,Mileage,Fuel,InitialLocation);

        Cars.add(newCar);

        return "Car was saved";
    }

    @DeleteMapping("v1/Cars/{id}")
    String deleteEmployee(@PathVariable Long id) {
        Cars.removeIf(car -> id==car.getID());
        return "Car was deleted";
    }

}
