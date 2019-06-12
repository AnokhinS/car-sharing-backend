package com.example.carsharingbackend.vaadinviews.customer.order.impl;

import com.example.carsharingbackend.entity.Order;
import com.example.carsharingbackend.restClients.RestOrderClient;
import com.example.carsharingbackend.security.Authorization;
import com.example.carsharingbackend.vaadinviews.customer.order.OrderPresenter;

public class OrderModelImpl implements OrderPresenter.OrderModel {

    private RestOrderClient client;

    public OrderModelImpl() {
        this.client = new RestOrderClient();
    }


    @Override
    public void createOrder(Order order) {
        order.setUser(Authorization.currentUser());
        client.create(order);
    }
}
