package com.example.carsharingbackend.view;

import com.example.carsharingbackend.vaadinviews.registration.RegistrationPresenter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("test")
public class TestView extends VerticalLayout {
    RegistrationPresenter presenter;

    public TestView(RegistrationPresenter p) {
        presenter= p;
        add(presenter.getView());
    }

}
