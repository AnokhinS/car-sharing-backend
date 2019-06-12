package com.example.carsharingbackend.vaadinviews.profile.impl;

import com.example.carsharingbackend.entity.Order;
import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.utils.ComponentBuilder;
import com.example.carsharingbackend.utils.PageWrapper;
import com.example.carsharingbackend.vaadinviews.profile.ProfilePresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.context.annotation.Scope;

import java.util.Collection;

@SpringComponent
@Scope(value = "prototype")
public class ProfileViewImpl extends HorizontalLayout implements ProfilePresenter.ProfileView {

    private VerticalLayout userInfo;
    private Grid<Order> orderGrid;

    public ProfileViewImpl() {
        setSizeFull();
        initGrid();
    }



    private VerticalLayout getUserInfo(User user){
        VerticalLayout info = new VerticalLayout();
        info.setWidth("300px");
        Label[] labels = {new Label("Имя"),new Label("Фамилия"),new Label("Email"),new Label("Роли")};
        Label[] inf = {new Label(user.getFirstName()),new Label(user.getLastName()),new Label(user.getEmail()),new Label(user.getRoles().toString())};

        for (int i= 0;i<labels.length;i++){
            Label l1 = labels[i];
            Label l2 = inf[i];
            l1.setWidth("100px");
            l1.getElement().getStyle().set("color","blue");
            l2.setWidth("200px");
            info.add(ComponentBuilder.toHorizontal(l1,l2));
        }


        return info;
    }

    private void initGrid(){
        orderGrid = new Grid<>();
        orderGrid.setWidth("1000px");
        orderGrid.addColumn(Order::getState).setHeader("Статус").setSortable(true).setWidth("50px");
        orderGrid.addColumn(Order::getCreationDate).setHeader("Дата создания").setSortable(true);
        orderGrid.addColumn(Order::getCar).setHeader("Автомобиль").setSortable(true);
        orderGrid.addColumn(Order::getStartDate).setHeader("Начало пользования").setSortable(true);
        orderGrid.addColumn(Order::getEndDate).setHeader("Конец пользования").setSortable(true);
        orderGrid.addColumn(Order::getSum).setHeader("Общая стоимость").setSortable(true).setWidth("50px");
    }


    @Override
    public Component mainLayout() {
        return new PageWrapper(this);
    }

    @Override
    public void setUser(User user) {
        userInfo = getUserInfo(user);
        add(userInfo);
    }

    @Override
    public void setOrders(Collection<Order> orders) {
        if(orders.size()==0){
            add(new H3("Вы еще не пользовались нашими услугами"));
            return;
        }
        orderGrid.setItems(orders);
        add(orderGrid);
    }
}
