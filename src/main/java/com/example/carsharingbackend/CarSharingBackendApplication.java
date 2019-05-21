package com.example.carsharingbackend;

import com.example.carsharingbackend.entity.carinfo.Car;
import com.example.carsharingbackend.entity.carinfo.Firm;
import com.example.carsharingbackend.entity.carinfo.Transmission;
import com.example.carsharingbackend.entity.carinfo.Type;
import com.example.carsharingbackend.repositories.CarRepository;
import com.example.carsharingbackend.repositories.NamedBeanRepository;
import com.example.carsharingbackend.repositories.TransmissionRepository;
import com.example.carsharingbackend.repositories.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@SpringBootApplication
public class CarSharingBackendApplication {

    private static final Logger log = LoggerFactory.getLogger(CarSharingBackendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CarSharingBackendApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(CarRepository carRepository, NamedBeanRepository<Firm> firmRepository, TypeRepository typeRepository, TransmissionRepository transmissionRepository) {
        return (args) -> {

            firmRepository.save(new Firm("Mazda"));
            firmRepository.save(new Firm("Nissan"));
            firmRepository.save(new Firm("BMW"));

            typeRepository.save(new Type("Грузовой"));
            typeRepository.save(new Type("Легковой"));

            transmissionRepository.save(new Transmission("Ручная"));
            transmissionRepository.save(new Transmission("Автомат"));

            // fetch all customers

            carRepository.save(new Car("опис1", new Firm(1), new Type(1), new Transmission(1), 55));
            carRepository.save(new Car("опис2", new Firm(2), new Type(1), new Transmission(1), 60));
            carRepository.save(new Car("опис3", new Firm(3), new Type(1), new Transmission(1), 70));


//            RestTemplate restTemplate = new RestTemplate();
//            String fooResourceUrl
//                    = "http://localhost:8080/restapi/cars";
//            ResponseEntity<String> response
//                    = restTemplate.getForEntity(fooResourceUrl + "?list=costPerDay>60", String.class);
//            System.out.println(response.getBody());
        };


    }


}
