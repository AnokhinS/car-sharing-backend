package com.example.carsharingbackend.entity.carinfo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "firm_id")
    private Firm firm;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "transmission_id")
    private Transmission transmission;
    @Column(name = "cost_per_day")
    private int costPerDay;

}
