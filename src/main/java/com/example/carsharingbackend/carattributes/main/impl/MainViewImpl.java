package com.example.carsharingbackend.carattributes.main.impl;

import com.example.carsharingbackend.carattributes.main.MainPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class MainViewImpl extends SplitLayout implements MainPresenter.MainView {
    public MainViewImpl() {
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
