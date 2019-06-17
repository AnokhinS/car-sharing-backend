package com.example.carsharingbackend.vaadinviews.admin.cars.main.impl;

import com.example.carsharingbackend.vaadinviews.admin.cars.main.CarPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class CarViewImpl extends HorizontalLayout implements CarPresenter.CarView {
    public CarViewImpl() {
        setSizeFull();
    }



    @Override
    public Component mainLayout() {
        return this;
    }

    @Override
    public void addComponents(Component... components) {
        add(components);
    }
}
