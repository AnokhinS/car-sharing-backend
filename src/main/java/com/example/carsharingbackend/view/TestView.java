package com.example.carsharingbackend.view;

import com.example.carsharingbackend.carattributes.main.MainPresenter;
import com.example.carsharingbackend.cars.CarPresenter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("test")

public class TestView extends VerticalLayout {
    CarPresenter presenter;


    public TestView(CarPresenter p) {
        presenter= p;
        add(presenter.getView());
    }
}
