package com.example.carsharingbackend.repositories;

import com.example.carsharingbackend.entity.Sum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SumRepository extends JpaRepository<Sum, Long> {
}

