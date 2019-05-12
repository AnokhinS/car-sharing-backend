package com.example.carsharingbackend.repositories;


import com.example.carsharingbackend.entity.carinfo.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
