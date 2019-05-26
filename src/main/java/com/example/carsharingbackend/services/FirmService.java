package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.carinfo.FirmEntity;
import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.repositories.FirmRepository;
import org.springframework.stereotype.Service;


@Service
public class FirmService extends NamedBeanService<FirmEntity> {

    public FirmService(FirmRepository repository) {
        super(repository);
    }

    @Override
    public NamedBean newBean() {
        return new FirmEntity();
    }
}