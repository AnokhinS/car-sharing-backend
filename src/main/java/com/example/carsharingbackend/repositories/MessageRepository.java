package com.example.carsharingbackend.repositories;


import com.example.carsharingbackend.entity.userinfo.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // Iterable<Message> findByUserAndReadFalseOrderByDateDesc(long userId);
}
