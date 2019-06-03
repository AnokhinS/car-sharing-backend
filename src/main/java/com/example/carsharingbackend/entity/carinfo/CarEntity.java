package com.example.carsharingbackend.entity.carinfo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
@Data
public class CarEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private long id;
    @Column(name = "description")
    private String description;
    @Column(name = "year")
    private double year;
    @ManyToOne
    @JoinColumn(name = "firm_id")
    private FirmEntity firm;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeEntity type;
    @ManyToOne
    @JoinColumn(name = "transmission_id")
    private TransmissionEntity transmission;
    @Column(name = "cost_per_day")
    private double costPerDay;
    @Column(name = "image_url")
    private String imageUrl;


    public CarEntity() {
    }

    public CarEntity(long id) {
        this.id = id;
    }

    public CarEntity(String description, int year, FirmEntity firm, TypeEntity type, TransmissionEntity transmission, double costPerDay, String imageUrl) {
        this.description = description;
        this.year = year;
        this.firm = firm;
        this.type = type;
        this.transmission = transmission;
        this.costPerDay = costPerDay;
        this.imageUrl = imageUrl;
    }
}
