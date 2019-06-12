package com.example.carsharingbackend.view;

import com.example.carsharingbackend.vaadinviews.profile.ProfilePresenter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;

@Route("myprofile")
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class ProfileView extends VerticalLayout {
    ProfilePresenter presenter;

    public ProfileView(ProfilePresenter p) {
        presenter = p;
        add(presenter.getView());
    }

}
