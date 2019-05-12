package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.Sum;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.repositories.SumRepository;
import org.springframework.stereotype.Service;


@Service
public class SumService {
    private SumRepository repository;

    public SumService(SumRepository repository) {
        this.repository = repository;
    }

    public Iterable<Sum> findAll() {
        return repository.findAll();
    }

    public Sum findById(long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public void delete(Sum object) {
        repository.delete(object);
    }

    public void save(Sum object) throws Exception {
        repository.save(object);
    }
}