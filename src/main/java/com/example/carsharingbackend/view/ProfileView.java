package com.example.carsharingbackend.view;

import com.example.carsharingbackend.security.autorities.Authorized;
import com.example.carsharingbackend.vaadinviews.profile.ProfilePresenter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("myprofile")
public class ProfileView extends VerticalLayout implements Authorized {
    ProfilePresenter presenter;

    public ProfileView(ProfilePresenter p) {
        presenter = p;
        add(presenter.getView());
    }

}
