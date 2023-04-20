package at.fhcampuswien.carrental.carrentalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
/*
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

*/

import at.fhcampuswien.carrental.carrentalservice.restservice.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ConfigurationPropertiesScan
//@EnableSwagger2
public class CarRentalServiceApplication {

	static List<Car> Cars = new ArrayList<>();
	static List<Customer> Customers = new ArrayList<>();
	static List<Rental> Rentals = new ArrayList<>();
	static int lastCarid=0;
	static int lastCustomerid=0;
	static int lastrentalid=0;

	public static void main(String[] args) {
		SpringApplication.run(CarRentalServiceApplication.class, args);
	}


	public static List<Car> getCars() {
		return Cars;
	}
	public static void addCar(String Model,Date Year,double Price, boolean Automatic,int Mileage,String Fuel,String InitialLocation){

		lastCarid = lastCarid+1;

		Car CartoAdd = new Car(lastCarid,Model,Year,Price,Automatic,Mileage,Fuel,InitialLocation);

		Cars.add(CartoAdd);

	}


	public static Car getCar(int id){
		return Cars.stream().filter(car -> id==car.getID()).findAny().orElse(null);
	}

	public static void deleteCar(int id){
		Cars.removeIf(car -> id==car.getID());
	}

	public static void registerCustomer(){

	}

	public static Customer getCustomer(String Email, String Password){
		return null;
	}

	public static void deleteSession(int SessionID){

	}

	public static void editcustomer(){

	}

	public static void getCustomerDetails(){

	}

	public static void deleteCustomer(){

	}

	public static void getRentals(){

	}

	public static void createRental(){

	}

	public static void editRental(){

	}

	public static void getRentalDetails(){

	}





	/*
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("at.fhcampuswien.carrental.carrentalservice")).build();
	}
	 */

}
