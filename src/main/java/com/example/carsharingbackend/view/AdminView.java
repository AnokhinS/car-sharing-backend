package com.example.carsharingbackend.view;

import com.example.carsharingbackend.vaadinviews.admin.AdminPresenter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("admin")
public class AdminView extends VerticalLayout {
    AdminPresenter presenter;

    public AdminView(AdminPresenter p) {
        presenter = p;
        add(presenter.getView());
    }

}
