package com.example.carsharingbackend.utils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.html.Image;


public class PageWrapper extends AppLayout {
    public PageWrapper(Component component) {
        getElement().getStyle().set("align-items","center");
        initMenu();
        setLogo();
        setContent(component);
    }

    private void setLogo() {
        Image img = new Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo");
        img.setHeight("44px");
        setBranding(img);
    }

    private void initMenu() {
        AppLayoutMenu menu = createMenu();
        menu.addMenuItems(new AppLayoutMenuItem("Войти", "login"),
                new AppLayoutMenuItem("Регистрация", "registration"),
                new AppLayoutMenuItem("Главная", "main"),
                new AppLayoutMenuItem("Мой профиль", "myprofile"),
                new AppLayoutMenuItem("Администраторам", "admin"));
    }
}
