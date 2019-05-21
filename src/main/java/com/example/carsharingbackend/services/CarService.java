package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.carinfo.Car;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.repositories.CarRepository;
import com.example.carsharingbackend.specifications.CarSpecification;
import com.example.carsharingbackend.specifications.CarSpecificationsBuilder;
import com.example.carsharingbackend.specifications.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class CarService {
    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Collection<Car> findAll() {

        return repository.findAll();
    }

    public Collection<Car> findAll(Specification<Car> spec) {

        return repository.findAll(spec);
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