package com.example.carsharingbackend.carattributes.navigation.impl;

import com.example.carsharingbackend.common.AttributeService;
import com.example.carsharingbackend.carattributes.navigation.NavigationPresenter;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.List;

@SpringComponent
@UIScope
public class NavigationViewImpl extends VerticalLayout implements NavigationPresenter.NavigationView {
    private ListBox<AttributeService> listOfLinks = new ListBox<>();


    public NavigationViewImpl() {
        add(listOfLinks);
        setWidth("300px");
    }


    @Override
    public Component mainLayout() {
        return this;
    }


    @Override
    public void setItems(List<AttributeService> links) {
        listOfLinks.setItems(links);
    }

    @Override
    public Registration addValueChangeListener(HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<ListBox<AttributeService>, AttributeService>> listener) {

        return listOfLinks.addValueChangeListener(listener);
    }
}






