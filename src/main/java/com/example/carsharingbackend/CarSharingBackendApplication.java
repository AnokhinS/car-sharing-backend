package com.example.carsharingbackend;

import com.example.carsharingbackend.entity.carinfo.Firm;
import com.example.carsharingbackend.entity.carinfo.Transmission;
import com.example.carsharingbackend.entity.carinfo.Type;
import com.example.carsharingbackend.repositories.NamedBeanRepository;
import com.example.carsharingbackend.repositories.TransmissionRepository;
import com.example.carsharingbackend.repositories.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarSharingBackendApplication {

    private static final Logger log = LoggerFactory.getLogger(CarSharingBackendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CarSharingBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(NamedBeanRepository<Firm> firmRepository, TypeRepository typeRepository, TransmissionRepository transmissionRepository) {
        return (args) -> {

            firmRepository.save(new Firm("Mazda"));
            firmRepository.save(new Firm("Nissan"));
            firmRepository.save(new Firm("BMW"));

            typeRepository.save(new Type("Грузовой"));
            typeRepository.save(new Type("Легковой"));

            transmissionRepository.save(new Transmission("Ручная"));
            transmissionRepository.save(new Transmission("Автомат"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Firm customer : firmRepository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Firm firm = firmRepository.findById(1L).get();
            log.info("Firm found with findOne(1L):");
            log.info("--------------------------------");
            log.info(firm.toString());
            log.info("");

        };
    }


}
