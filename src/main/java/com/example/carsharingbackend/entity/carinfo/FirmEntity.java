package com.example.carsharingbackend.entity.carinfo;

import com.example.carsharingbackend.entity.common.NamedBean;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "firm")
@Data
public class FirmEntity implements NamedBean, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "firm_id")
    private long id;

    @Column(name = "name")
    private String name;

    public FirmEntity() {
    }

    public FirmEntity(long i) {
        id = i;
    }

    public FirmEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public FirmEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
