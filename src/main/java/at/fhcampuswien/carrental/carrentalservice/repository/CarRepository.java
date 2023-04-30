package at.fhcampuswien.carrental.carrentalservice.repository;

import at.fhcampuswien.carrental.carrentalservice.entity.CarAttribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@EnableJpaRepositories
public interface CarRepository extends CrudRepository<CarAttribute, Integer> {
    void deleteAllById(int id);

}
