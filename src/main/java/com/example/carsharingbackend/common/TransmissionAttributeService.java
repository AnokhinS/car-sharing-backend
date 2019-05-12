package com.example.carsharingbackend.common;

import com.example.carsharingbackend.services.FirmService;
import com.example.carsharingbackend.services.NamedBeanService;
import com.example.carsharingbackend.services.TransmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TransmissionAttributeService implements AttributeService {
    @Autowired
    private ApplicationContext context;
    @Override
    public NamedBeanService getService() {
        return context.getBean(TransmissionService.class);
    }
    @Override
    public String toString() {
        return "Коробка передач";
    }
}
