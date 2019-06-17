package com.example.carsharingbackend.view;

import com.example.carsharingbackend.vaadinviews.customer.main.CustomerActivityPresenter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("main")
public class MainPage extends VerticalLayout {
    CustomerActivityPresenter presenter;

    public MainPage(CustomerActivityPresenter presenter) {
        this.presenter = presenter;
        add(presenter.getView());
    }
}
