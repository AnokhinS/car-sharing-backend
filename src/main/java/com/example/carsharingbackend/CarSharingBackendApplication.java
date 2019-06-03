package com.example.carsharingbackend;

import com.example.carsharingbackend.entity.Order;
import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.entity.carinfo.FirmEntity;
import com.example.carsharingbackend.entity.carinfo.TransmissionEntity;
import com.example.carsharingbackend.entity.carinfo.TypeEntity;
import com.example.carsharingbackend.entity.userinfo.Role;
import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.HashSet;

@SpringBootApplication
public class CarSharingBackendApplication {



    private static final Logger log = LoggerFactory.getLogger(CarSharingBackendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CarSharingBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CarRepository carRepository, NamedBeanRepository<FirmEntity> firmRepository, OrderRepository orderRepository,
                                      TypeRepository typeRepository, TransmissionRepository transmissionRepository, UserRepository userRepository) {
        return (args) -> {

            firmRepository.save(new FirmEntity("Mazda"));
            firmRepository.save(new FirmEntity("Nissan"));
            firmRepository.save(new FirmEntity("BMW"));

            typeRepository.save(new TypeEntity("Грузовой"));
            typeRepository.save(new TypeEntity("Легковой"));

            transmissionRepository.save(new TransmissionEntity("Ручная"));
            transmissionRepository.save(new TransmissionEntity("Автомат"));


            carRepository.save(new CarEntity("опис1", 1990, new FirmEntity(1), new TypeEntity(2), new TransmissionEntity(2), 55, "https://s3-ap-southeast-1.amazonaws.com/caarlyd/img/613260-small.png"));
            carRepository.save(new CarEntity("опис2", 2000, new FirmEntity(2), new TypeEntity(2), new TransmissionEntity(2), 60, "https://77sto.ru/assets/cache_image/images/subcat/18_256x256_177.jpg"));
            carRepository.save(new CarEntity("опис3", 2015, new FirmEntity(3), new TypeEntity(2), new TransmissionEntity(2), 70, "https://bmwa.ru/upload/000/u1/b/2/e9f6bb5c.jpg"));
            carRepository.save(new CarEntity("опис3", 2015, new FirmEntity(3), new TypeEntity(2), new TransmissionEntity(2), 70, "https://bmwa.ru/upload/000/u1/b/2/e9f6bb5c.jpg"));


            HashSet<Role> userRole = new HashSet<>();
            userRole.add(Role.USER);

            HashSet<Role> adminRole = new HashSet<>();
            adminRole.add(Role.ADMIN);

            userRepository.save(new User("Сергей", "Анохин","testmail@mail.ru","sdasdadas221",true,userRole));
            userRepository.save(new User("Сергей", "Анохин","workout@mail.ru","sdasdadas221",true,userRole));
            userRepository.save(new User("Сергей", "Анохин","meal@mail.ru","sdasdadas221",true,adminRole));


            User user= userRepository.findById(1l).get();
            CarEntity carEntity=carRepository.findById(1l).get();

            orderRepository.save(new Order(user, carEntity,LocalDate.of(2019,5,31),LocalDate.of(2019,6,10)));
            orderRepository.save(new Order(new User(1), new CarEntity(2),LocalDate.of(2019,5,31),LocalDate.of(2019,6,15)));
            orderRepository.save(new Order(new User(1), new CarEntity(3),LocalDate.of(2019,5,31),LocalDate.of(2019,6,20)));

        };


    }


}
