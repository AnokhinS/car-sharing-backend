package com.example.carsharingbackend.vaadinviews.admin.impl;


import com.example.carsharingbackend.vaadinviews.admin.AdminPresenter;
import com.example.carsharingbackend.utils.PageWrapper;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Getter;

@SpringComponent
@UIScope
public class AdminViewImpl extends VerticalLayout implements AdminPresenter.AdminView {
    @Getter
    private Button attBtn = new Button("Параметры");
    @Getter
    private Button carsBtn = new Button("Автомобили");
    @Getter
    private Button usersBtn = new Button("Пользователи");
    private Button help = new Button("Help");

    Component currentComponent = new VerticalLayout();

    public AdminViewImpl() {
        buildMainLayout();
        add(currentComponent);
    }

    private void buildMainLayout() {
        setSizeFull();
        add(createToolbar());
    }


    public HorizontalLayout createToolbar() {
        HorizontalLayout toolbar = new HorizontalLayout();
        toolbar.add(attBtn);
        toolbar.add(carsBtn);
        toolbar.add(usersBtn);
        toolbar.add(help);
        return toolbar;
    }

    @Override
    public void setView(Component component) {
        replace(currentComponent, component);
        currentComponent = component;
    }

    @Override
    public Component mainLayout() {
        return new PageWrapper(this);
    }
}

