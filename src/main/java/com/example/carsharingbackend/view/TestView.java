package com.example.carsharingbackend.view;

import com.example.carsharingbackend.namedbean.grid.GridPresenter;
import com.example.carsharingbackend.namedbean.main.MainPresenter;
import com.example.carsharingbackend.services.FirmService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("test")
public class TestView extends VerticalLayout {
    MainPresenter presenter;


    public TestView(MainPresenter p, FirmService service) {
        presenter=p;
        add(presenter.getView());
    }
}
