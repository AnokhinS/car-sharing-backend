package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.carinfo.TransmissionEntity;
import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.repositories.TransmissionRepository;
import org.springframework.stereotype.Service;


@Service
public class TransmissionService extends NamedBeanService<TransmissionEntity> {

    public TransmissionService(TransmissionRepository repository) {
        super(repository);

    }


    @Override
    public NamedBean newBean() {
        return new TransmissionEntity();
    }
}