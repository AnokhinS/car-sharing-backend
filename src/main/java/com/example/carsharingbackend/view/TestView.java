package com.example.carsharingbackend.view;

import com.example.carsharingbackend.vaadinviews.mainlayout.MainPresenter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("test")
public class TestView extends VerticalLayout {
    MainPresenter presenter;

    public TestView(MainPresenter p) {
        presenter = p;
        add(presenter.getView());
    }

}
