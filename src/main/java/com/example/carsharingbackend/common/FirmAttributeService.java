package com.example.carsharingbackend.common;

import com.example.carsharingbackend.services.FirmService;
import com.example.carsharingbackend.services.NamedBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class FirmAttributeService implements AttributeService {
    @Autowired
    private ApplicationContext context;
    @Override
    public NamedBeanService getService() {
        System.out.println(context);
        return context.getBean(FirmService.class);
    }

    @Override
    public String toString() {
        return "Производитель";
    }
}
