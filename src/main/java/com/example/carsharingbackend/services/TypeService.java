package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.carinfo.TypeEntity;
import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.repositories.TypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeService extends NamedBeanService<TypeEntity> {
    public TypeService(TypeRepository repository) {
        super(repository);
    }

    @Override
    public NamedBean newBean() {
        return new TypeEntity();
    }
}