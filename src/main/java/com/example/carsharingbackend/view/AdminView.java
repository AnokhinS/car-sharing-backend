package com.example.carsharingbackend.view;

import com.example.carsharingbackend.vaadinviews.admin.AdminPresenter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.security.access.annotation.Secured;

@Route("admin")
@Secured({ "ROLE_ADMIN" })
public class AdminView extends VerticalLayout {
    AdminPresenter presenter;

    public AdminView(AdminPresenter p) {
        presenter = p;
        add(presenter.getView());
    }

}
