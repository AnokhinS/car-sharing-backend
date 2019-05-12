package com.example.carsharingbackend.carattributes.grid.impl;

import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.carattributes.grid.GridPresenter;
import com.example.carsharingbackend.services.NamedBeanService;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class GridModelImpl implements GridPresenter.GridModel {

    @Setter
    private NamedBeanService service;

    @Override
    public Collection<NamedBean> getAll() {
        return service.getAllOrdered();
    }

    @Override
    public Collection<NamedBean> getAllStartsWith(String str) {
        return service.getAllStartsWith(str);
    }

    @Override
    public NamedBean newBean() {
        return service.newBean();
    }
}
