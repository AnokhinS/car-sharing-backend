package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.carinfo.Car;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.repositories.CarRepository;
import org.springframework.stereotype.Service;


@Service
public class CarService {
    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Iterable<Car> findAll() {
        return repository.findAll();
    }

    public Car get(long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public Car create(Car object) {
        return repository.save(object);
    }


    public Car update(Car object) {
        get(object.getId());
        return repository.save(object);
    }

    public void delete(Car object) {
        repository.delete(get(object.getId()));
    }

}