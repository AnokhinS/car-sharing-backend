package com.example.carsharingbackend.vaadinviews.profile.impl;

import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.restClients.RestOrderClient;
import com.example.carsharingbackend.security.Authorization;
import com.example.carsharingbackend.vaadinviews.profile.ProfilePresenter;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class ProfileModelImpl implements ProfilePresenter.ProfileModel {

    private RestOrderClient orderClient;

    public ProfileModelImpl(RestOrderClient orderClient) {
        this.orderClient = orderClient;
    }


    @Override
    public User getUser() {
        return Authorization.currentUser();
    }
}
