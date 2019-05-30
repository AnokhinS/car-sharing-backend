package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.repositories.CarRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class CarService {
    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Collection<CarEntity> findAll() {

        return repository.findAll();
    }

    public Collection<CarEntity> findAll(Specification<CarEntity> spec) {
        return repository.findAll(spec);
    }

    public CarEntity get(long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public CarEntity create(CarEntity object) {
        return repository.save(object);
    }


    public CarEntity update(CarEntity object) {
        get(object.getId());
        return repository.save(object);
    }

    public void delete(long id) {
        repository.delete(get(id));
    }

}