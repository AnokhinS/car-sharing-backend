package com.example.carsharingbackend.repositories;

import com.example.carsharingbackend.entity.Order;
import com.example.carsharingbackend.entity.userinfo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUser(User user);

    @Query(
            value = "SELECT sum FROM order_sum where order_id=?",
            nativeQuery = true)
    int getSum(long id);

    @Query(
            value = "select test()",
            nativeQuery = true)
    long getId();
}
