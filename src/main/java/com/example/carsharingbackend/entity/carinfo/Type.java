package com.example.carsharingbackend.entity.carinfo;

import com.example.carsharingbackend.entity.common.NamedBean;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "type")
@Data
public class Type implements NamedBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private long id;

    @Length(min = 1, message = "Поле не может быть пустым")
    @Column(name = "name")
    private String name;

    public Type() {
    }

    public Type(@Length(min = 1, message = "Поле не может быть пустым") String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
