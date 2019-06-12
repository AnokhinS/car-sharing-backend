package com.example.carsharingbackend.vaadinviews.admin.users.impl;

import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.restClients.RestUserClient;
import com.example.carsharingbackend.vaadinviews.admin.users.UserPresenter;
import com.vaadin.flow.spring.annotation.SpringComponent;

import java.util.Collection;

@SpringComponent
public class UserModelImpl implements UserPresenter.UserModel {

    public UserModelImpl(RestUserClient client) {
        this.client = client;
    }

    private RestUserClient client;

    @Override
    public Collection<User> getAll(String startsWith) {
        return client.list(startsWith);
    }
}
