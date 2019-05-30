package com.example.carsharingbackend.vaadinviews.admin.carattributes.main.impl;

import com.example.carsharingbackend.vaadinviews.admin.carattributes.main.CarAttributePresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class CarAttributeViewImpl extends SplitLayout implements CarAttributePresenter.CarAttributeView {
    public CarAttributeViewImpl() {
        setSizeFull();
    }

    @Override
    public Component mainLayout() {
        return this;
    }

    @Override
    public void setFirstComponent(Component comp) {
        addToPrimary(comp);
    }

    @Override
    public void setSecondComponent(Component comp) {
        addToSecondary(comp);
    }
}
