package com.example.carsharingbackend.entity.carinfo;

import com.example.carsharingbackend.entity.common.NamedBean;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "firm")
@Data
public class Firm implements NamedBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "firm_id")
    private long id;

    @Column(name = "name")
    private String name;

    public Firm() {
    }


    public Firm(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
