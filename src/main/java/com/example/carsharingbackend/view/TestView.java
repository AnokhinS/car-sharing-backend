package com.example.carsharingbackend.view;

import com.example.carsharingbackend.vaadinviews.admin.AdminPresenter;
import com.example.carsharingbackend.vaadinviews.profile.ProfilePresenter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("test")
public class TestView extends VerticalLayout {
    ProfilePresenter presenter;

    public TestView(ProfilePresenter p) {
        presenter = p;
        add(presenter.getView());
    }

}
