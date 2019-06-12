package com.example.carsharingbackend.vaadinviews.customer.carselection.impl;

import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.vaadinviews.customer.carselection.CarSelectionPresenter;
import com.example.carsharingbackend.vaadinviews.customer.carselection.utils.CarWrapper;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.Collection;


@SpringComponent
@UIScope
public class CarSelectionViewImpl extends VerticalLayout implements CarSelectionPresenter.CarSelectionView {

    public CarSelectionViewImpl() {

    }

    @Override
    public void setData(Collection<CarEntity> collection) {
        removeAll();
        collection.forEach(c -> add(new CarWrapper(c)));
        if (getComponentCount() == 0) {
            add(new Span(new H2("Автомобилей, удовлетворяющих выбранным критериям, нет")));
        }
    }

    @Override
    public Component mainLayout() {
        return this;
    }
}
