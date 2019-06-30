package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.repositories.CarRepository;
import com.example.carsharingbackend.specifications.CarSpecificationsBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Service
public class CarService {
    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Collection<CarEntity> findAll() {

        return repository.findAll();
    }

    public Collection<CarEntity> findAll(String costFrom, String costTo,
                                         String firms, String types,
                                         String transmissions,
                                         String yearFrom, String yearTo) {

        CarSpecificationsBuilder builder = new CarSpecificationsBuilder();
        builder.with("costPerDay", ">", costFrom, false);
        builder.with("costPerDay", "<", costTo, false);
        builder.with("year", ">", yearFrom, false);
        builder.with("year", "<", yearTo, false);

        if (firms != null) {
            List<String> flist = Arrays.asList(firms.split(","));
            flist.forEach(e -> {
                builder.with("firm.name", "=", e, true);
            });
        }
        if (types != null) {
            List<String> tlist = Arrays.asList(types.split(","));
            tlist.forEach(e -> {
                builder.with("type.name", "=", e, true);
            });
        }
        if (transmissions != null) {
            List<String> trlist = Arrays.asList(transmissions.split(","));
            trlist.forEach(e -> {
                builder.with("transmission.name", "=", e, true);
            });
        }
        Specification<CarEntity> spec = builder.build();


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