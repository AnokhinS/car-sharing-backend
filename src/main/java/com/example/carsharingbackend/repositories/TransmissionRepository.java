package com.example.carsharingbackend.repositories;

import com.example.carsharingbackend.entity.carinfo.TransmissionEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TransmissionRepository extends NamedBeanRepository<TransmissionEntity> {
}

