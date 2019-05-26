package com.example.carsharingbackend.repositories;


import com.example.carsharingbackend.entity.carinfo.TypeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends NamedBeanRepository<TypeEntity> {
}
