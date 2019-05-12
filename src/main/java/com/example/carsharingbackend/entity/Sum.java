package com.example.carsharingbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_sum")
public class Sum {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sum")
    private int sum;

}
