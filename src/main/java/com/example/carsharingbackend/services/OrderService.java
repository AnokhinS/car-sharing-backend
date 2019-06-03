package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.Order;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class OrderService {
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Collection<Order> findAll() {
        return repository.findAll();
    }

    public Collection<Order> findAllByUser(long id) {
        return repository.findAllByUser(id);
    }

    public Order get(long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public Order create(Order object) {
        object.setId(0);
        return repository.save(object);
    }


    public void update(Order object) {
        get(object.getId());
        repository.save(object);
    }

    public void delete(long id) {
        repository.delete(get(id));
    }

}