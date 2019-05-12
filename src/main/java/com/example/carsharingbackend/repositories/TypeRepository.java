package com.example.carsharingbackend.repositories;


import com.example.carsharingbackend.entity.carinfo.Type;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends NamedBeanRepository<Type> {
}
