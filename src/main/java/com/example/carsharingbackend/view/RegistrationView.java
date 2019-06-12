package com.example.carsharingbackend.view;

import com.example.carsharingbackend.vaadinviews.admin.AdminPresenter;
import com.example.carsharingbackend.vaadinviews.registration.RegistrationPresenter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("registration")
public class RegistrationView extends VerticalLayout {
    RegistrationPresenter presenter;

    public RegistrationView(RegistrationPresenter p) {
        presenter = p;
        add(presenter.getView());
    }

}
