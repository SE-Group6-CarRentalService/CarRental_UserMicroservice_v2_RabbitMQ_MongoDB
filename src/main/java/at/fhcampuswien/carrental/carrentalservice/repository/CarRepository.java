package at.fhcampuswien.carrental.carrentalservice.repository;

import at.fhcampuswien.carrental.carrentalservice.restservice.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@EnableJpaRepositories
public interface CarRepository extends CrudRepository<Car, Integer> {
    void deleteAllById(int id);

    //Car findCarBy(int id);
    //List<Car> findAll();
    //void deleteCarBy(long id);
    //void deleteCarBy(Long id);
    //void deleteCarBy(int id);

}
