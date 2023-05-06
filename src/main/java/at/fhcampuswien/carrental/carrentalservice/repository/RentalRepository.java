package at.fhcampuswien.carrental.carrentalservice.repository;


import at.fhcampuswien.carrental.carrentalservice.entity.CustomerAttribute;
import at.fhcampuswien.carrental.carrentalservice.entity.RentalAttribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends CrudRepository<RentalAttribute, Integer> {

    List<RentalAttribute> findByCarId(int carId);

    List<RentalAttribute> findByCustomerId(int customerId);

    //List<RentalAttribute> findRentalByRentalID(int rentalId);
}
