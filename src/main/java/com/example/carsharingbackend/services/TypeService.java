package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.carinfo.Type;
import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.repositories.TypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeService extends NamedBeanService<Type> {
    public TypeService(TypeRepository repository) {
        super(repository);
    }

    @Override
    public NamedBean newBean() {
        return new Type();
    }
}