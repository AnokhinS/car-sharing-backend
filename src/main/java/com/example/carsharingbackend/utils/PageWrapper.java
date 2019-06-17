package com.example.carsharingbackend.utils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.login.LoginOverlay;
import org.springframework.security.core.context.SecurityContextHolder;


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
        Label login = new Label("Войти");
        login.getElement().addEventListener("click", e -> login());
        Label logout = new Label("Выйти");
        logout.getElement().addEventListener("click", e -> logout());

        AppLayoutMenu menu = createMenu();
        menu.addMenuItems(new AppLayoutMenuItem(login),
                new AppLayoutMenuItem("Регистрация", "registration"),
                new AppLayoutMenuItem("Главная", "main"),
                new AppLayoutMenuItem("Мой профиль", "myprofile"),
                new AppLayoutMenuItem("Администраторам", "admin"),
                new AppLayoutMenuItem(logout));

    }

    private void login() {
        LoginOverlay login = new LoginOverlay();
        login.setAction("login");
        login.setTitle("Carsharing");
        login.setDescription("Пожалуйста, авторизуйтесь");
        login.setOpened(true);

    }

    private void logout() {
        SecurityContextHolder.clearContext();
        UI.getCurrent().getSession().close();
        UI.getCurrent().getPage().reload();

    }
}
