package com.example.carsharingbackend.repositories;

import com.example.carsharingbackend.entity.userinfo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Collection<User> findByEmailStartsWithIgnoreCaseOrderByEmail(String startsWith);
    Optional<User> findByEmailIgnoreCase(String email);
}
