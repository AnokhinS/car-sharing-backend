package com.example.carsharingbackend.view;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.security.access.prepost.PreAuthorize;

@Route("test")
public class TestView extends VerticalLayout {

    public TestView() {
        add(new Label(new TestService().get()));
    }


    private class TestService {

        @PreAuthorize("hasAuthority('ADMIN')")
        public String get() {
            return "hello";
        }
    }
}
