package com.example.carsharingbackend.entity;

import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.utils.OrderSumHelper;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(name = "sum")
    private double sum;

    public Order() {
        this.creationDate = LocalDate.now();
    }

    public Order(User user, CarEntity car, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.car = car;
        this.creationDate = LocalDate.now();
        this.startDate = startDate;
        this.endDate = endDate;
        sum = OrderSumHelper.getSum(startDate, endDate, car.getCostPerDay());
    }
}
