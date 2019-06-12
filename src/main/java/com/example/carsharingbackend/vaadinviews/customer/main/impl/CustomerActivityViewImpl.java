package com.example.carsharingbackend.vaadinviews.customer.main.impl;

import com.example.carsharingbackend.vaadinviews.customer.main.CustomerActivityPresenter;
import com.example.carsharingbackend.utils.PageWrapper;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class CustomerActivityViewImpl extends HorizontalLayout implements CustomerActivityPresenter.CustomerActivityView {

    public CustomerActivityViewImpl() {

    }

    @Override
    public void addComponents(Component... components) {
        add(components);
    }

    @Override
    public Component mainLayout() {
        return new PageWrapper(this);
    }
}
