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
    @Column(name = "description")
    private String description;
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

    public Car() {
    }

    public Car(String desc, Firm firm, Type type, Transmission transmission, int costPerDay) {
        this.description = desc;
        this.firm = firm;
        this.type = type;
        this.transmission = transmission;
        this.costPerDay = costPerDay;
    }
}
