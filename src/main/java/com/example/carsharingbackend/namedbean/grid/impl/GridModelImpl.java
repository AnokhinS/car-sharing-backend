package com.example.carsharingbackend.namedbean.grid.impl;

import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.namedbean.grid.GridPresenter;
import com.example.carsharingbackend.services.NamedBeanService;
import lombok.Setter;

import java.util.Collection;

public class GridModelImpl implements GridPresenter.IGridModel {

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
