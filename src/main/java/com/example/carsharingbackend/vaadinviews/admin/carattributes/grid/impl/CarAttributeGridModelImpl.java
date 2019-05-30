package com.example.carsharingbackend.vaadinviews.admin.carattributes.grid.impl;

import com.example.carsharingbackend.vaadinviews.admin.carattributes.grid.CarAttributeGridPresenter;
import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.restClients.RestClient;
import com.vaadin.flow.spring.annotation.SpringComponent;

import java.util.Collection;

@SpringComponent
public class CarAttributeGridModelImpl implements CarAttributeGridPresenter.GridModel {

    private RestClient<NamedBean> client;

    @Override
    public Collection<NamedBean> getAllStartsWith(String str) {
        return client.list(str);
    }

    @Override
    public void save(NamedBean bean) {
        if (bean.getId() == 0) {
            client.create(bean);
        } else {
            client.update(bean.getId(), bean);
        }
    }

    @Override
    public void delete(long id) {
        client.delete(id);
    }

    @Override
    public NamedBean newBean() {
        return client.newBean();
    }

    @Override
    public void setRestNamedBeanClient(RestClient<NamedBean> client) {
        this.client=client;
    }

}
