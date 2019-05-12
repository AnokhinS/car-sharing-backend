package com.example.carsharingbackend.namedbean.main.impl;

import com.example.carsharingbackend.namedbean.main.MainPresenter;
import com.example.carsharingbackend.services.NamedBeanService;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class MainModelImpl implements MainPresenter.MainModel {
    @Getter
    private NamedBeanService firmService;
    @Getter
    private NamedBeanService typeService;
    @Getter
    private NamedBeanService transmissionService;

    public MainModelImpl(NamedBeanService firmService, NamedBeanService typeService, NamedBeanService transmissionService) {
        this.firmService = firmService;
        this.typeService = typeService;
        this.transmissionService = transmissionService;
    }
}
