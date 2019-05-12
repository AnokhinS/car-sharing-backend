package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.carinfo.Transmission;
import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.repositories.TransmissionRepository;
import org.springframework.stereotype.Service;


@Service
public class TransmissionService extends NamedBeanService<Transmission> {

    public TransmissionService(TransmissionRepository repository) {
        super(repository);

    }


    @Override
    public NamedBean newBean() {
        return new Transmission();
    }
}