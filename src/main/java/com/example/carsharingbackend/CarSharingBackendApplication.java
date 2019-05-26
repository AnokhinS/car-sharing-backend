package com.example.carsharingbackend;

import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.entity.carinfo.FirmEntity;
import com.example.carsharingbackend.entity.carinfo.TransmissionEntity;
import com.example.carsharingbackend.entity.carinfo.TypeEntity;
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

@SpringBootApplication
public class CarSharingBackendApplication {

    private static final Logger log = LoggerFactory.getLogger(CarSharingBackendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CarSharingBackendApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(CarRepository carRepository, NamedBeanRepository<FirmEntity> firmRepository, TypeRepository typeRepository, TransmissionRepository transmissionRepository) {
        return (args) -> {

            firmRepository.save(new FirmEntity("Mazda"));
            firmRepository.save(new FirmEntity("Nissan"));
            firmRepository.save(new FirmEntity("BMW"));

            typeRepository.save(new TypeEntity("Грузовой"));
            typeRepository.save(new TypeEntity("Легковой"));

            transmissionRepository.save(new TransmissionEntity("Ручная"));
            transmissionRepository.save(new TransmissionEntity("Автомат"));

            // fetch all customers

            carRepository.save(new CarEntity("опис1", new FirmEntity(1), new TypeEntity(1), new TransmissionEntity(1), 55));
            carRepository.save(new CarEntity("опис2", new FirmEntity(2), new TypeEntity(1), new TransmissionEntity(1), 60));
            carRepository.save(new CarEntity("опис3", new FirmEntity(3), new TypeEntity(1), new TransmissionEntity(1), 70));


        };


    }


}
