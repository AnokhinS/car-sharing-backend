package com.example.carsharingbackend.entity.carinfo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Data
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private long id;
    @Column(name = "description")
    private String description;
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
    private int costPerDay;

    public CarEntity() {
    }

    public CarEntity(String desc, FirmEntity firm, TypeEntity type, TransmissionEntity transmission, int costPerDay) {
        this.description = desc;
        this.firm = firm;
        this.type = type;
        this.transmission = transmission;
        this.costPerDay = costPerDay;
    }
}
