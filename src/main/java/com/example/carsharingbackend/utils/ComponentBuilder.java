package com.example.carsharingbackend.utils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ComponentBuilder {
    public static HorizontalLayout toHorizontal(Component c1, Component c2) {
        return new HorizontalLayout(c1, c2);
    }

}
