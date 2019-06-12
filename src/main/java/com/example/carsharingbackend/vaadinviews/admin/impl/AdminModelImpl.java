package com.example.carsharingbackend.vaadinviews.admin.impl;

import com.example.carsharingbackend.vaadinviews.admin.AdminPresenter;
import com.example.carsharingbackend.vaadinviews.admin.carattributes.main.CarAttributePresenter;
import com.example.carsharingbackend.vaadinviews.admin.cars.main.CarPresenter;
import com.example.carsharingbackend.vaadinviews.admin.users.UserPresenter;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;


@SpringComponent
@UIScope
public class AdminModelImpl implements AdminPresenter.AdminModel {

    private CarPresenter carPresenter;
    private UserPresenter userPresenter;
    private CarAttributePresenter attributePresenter;

    public AdminModelImpl(CarPresenter carPresenter, UserPresenter userPresenter, CarAttributePresenter attributePresenter) {
        this.carPresenter = carPresenter;
        this.userPresenter = userPresenter;
        this.attributePresenter = attributePresenter;
    }

    @Override
    public CarPresenter getCarPresenter() {
        return carPresenter;
    }

    @Override
    public UserPresenter getUserPresenter() {
        return userPresenter;
    }

    @Override
    public CarAttributePresenter getAttributesPresenter() {
        return attributePresenter;
    }
}
