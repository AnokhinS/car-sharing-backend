package com.example.carsharingbackend.entity.carinfo;

import com.example.carsharingbackend.entity.common.NamedBean;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "transmission")
@Data
public class Transmission implements NamedBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transmission_id")
    private long id;

    @Column(name = "name")
    private String name;

    public Transmission() {
    }

    public Transmission(String name) {
        this.name = name;
    }
}
