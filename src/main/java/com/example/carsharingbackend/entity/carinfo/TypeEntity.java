package com.example.carsharingbackend.entity.carinfo;

import com.example.carsharingbackend.entity.common.NamedBean;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "type")
@Data
public class TypeEntity implements NamedBean, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private long id;

    @Length(min = 1, message = "Поле не может быть пустым")
    @Column(name = "name")
    private String name;

    public TypeEntity() {
    }

    public TypeEntity(@Length(min = 1, message = "Поле не может быть пустым") String name) {
        this.name = name;
    }

    public TypeEntity(int i) {
        id = i;
    }


    @Override
    public String toString() {
        return name;
    }

}
