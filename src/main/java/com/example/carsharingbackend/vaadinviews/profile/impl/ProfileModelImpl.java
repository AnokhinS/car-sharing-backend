package com.example.carsharingbackend.vaadinviews.profile.impl;

import com.example.carsharingbackend.entity.Order;
import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.repositories.UserRepository;
import com.example.carsharingbackend.restClients.RestOrderClient;
import com.example.carsharingbackend.restClients.RestUserClient;
import com.example.carsharingbackend.security.Authorization;
import com.example.carsharingbackend.vaadinviews.profile.ProfilePresenter;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

@SpringComponent
public class ProfileModelImpl implements ProfilePresenter.ProfileModel {

    private RestOrderClient orderClient;

    public ProfileModelImpl(RestOrderClient orderClient) {
        this.orderClient = orderClient;
    }

    @Override
    public Collection<Order> getOrders() {
        return orderClient.list(""+getUser().getId());
    }

    @Override
    public User getUser() {
        return Authorization.currentUser();
    }
}
