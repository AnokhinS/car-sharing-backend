package com.example.carsharingbackend.vaadinviews.admin.cars.main.impl;

import com.example.carsharingbackend.vaadinviews.admin.cars.main.CarPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class CarViewImpl extends SplitLayout implements CarPresenter.CarView {
    public CarViewImpl() {
        setSizeFull();
        setSplitterPosition(300);
    }

    @Override
    public void setFirstComponent(Component... components) {

        addToPrimary(components);
    }

    @Override
    public void setSecondComponent(Component... components) {
        addToSecondary(components);
    }

    @Override
    public Component mainLayout() {
        return this;
    }
}
