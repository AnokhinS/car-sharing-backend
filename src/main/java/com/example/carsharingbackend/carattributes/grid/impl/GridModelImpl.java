package com.example.carsharingbackend.carattributes.grid.impl;

import com.example.carsharingbackend.carattributes.grid.GridPresenter;
import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.restClients.RestNamedBeanClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class GridModelImpl implements GridPresenter.GridModel {

    private RestNamedBeanClient client;

    @Override
    public Collection<NamedBean> getAllStartsWith(String str) {
        return client.list(str);
    }

    @Override
    public NamedBean newBean() {
        return client.newBean();
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
    public void setRestNamedBeanClient(RestNamedBeanClient client) {
        this.client=client;
    }

    @Override
    public void delete(NamedBean bean) {
        client.delete(bean.getId());
    }
}
