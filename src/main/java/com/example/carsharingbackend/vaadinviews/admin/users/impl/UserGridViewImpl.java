package com.example.carsharingbackend.vaadinviews.admin.users.impl;

import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.restClients.RestUserClient;
import com.example.carsharingbackend.vaadinviews.admin.users.UserPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Getter;

import java.util.Collection;

@SpringComponent
@UIScope
public class UserGridViewImpl extends VerticalLayout implements UserPresenter.UserView {
    @Getter
    private TextField filter;
    private Grid<User> grid;

    private RestUserClient client;

    public UserGridViewImpl() {
        client = new RestUserClient();
        filter = new TextField();
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.setPlaceholder("Фильтрация по email");
        filter.setWidth("300px");
        grid = new Grid<>();
        grid.setWidth("800px");
        grid.addColumn(User::getId).setHeader("Идентификатор").setSortable(true).setWidth("80px");
        grid.addColumn(User::getFirstName).setHeader("Имя").setSortable(true);
        grid.addColumn(User::getLastName).setHeader("Фамилия").setSortable(true);
        grid.addColumn(User::getEmail).setHeader("Email").setSortable(true);
        grid.addColumn(User::getRoles).setHeader("Роль").setSortable(true);
        grid.addComponentColumn(user -> createRemoveButton(user))
                .setHeader("Активность");
        HorizontalLayout actions = new HorizontalLayout(filter);
        add(actions, grid);
    }


    private Checkbox createRemoveButton(User user) {
        Checkbox checkbox = new Checkbox(user.isActive());
        checkbox.addValueChangeListener(e->{
            user.setActive(e.getValue());
            client.update(user.getId(),user);
            grid.getDataProvider().refreshAll();
        });
        return checkbox;
    }


    @Override
    public Component mainLayout() {
        return this;
    }

    @Override
    public void setData(Collection<User> list) {
        grid.setItems(list);
    }

}
