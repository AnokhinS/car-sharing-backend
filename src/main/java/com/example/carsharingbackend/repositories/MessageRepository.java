package com.example.carsharingbackend.repositories;


import com.example.carsharingbackend.entity.userinfo.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Collection<Message> findByUserIdAndReadFalseOrderByDateDesc(long userId);
}
