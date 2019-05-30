package com.example.carsharingbackend.entity.carinfo;

import com.example.carsharingbackend.entity.common.NamedBean;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "transmission")
@Data
public class TransmissionEntity implements NamedBean, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transmission_id")
    private long id;

    @Column(name = "name")
    private String name;

    public TransmissionEntity() {
    }

    public TransmissionEntity(String name) {
        this.name = name;
    }

    public TransmissionEntity(int i) {
        id=i;
    }


    @Override
    public String toString(){
        return name;
    }

}
