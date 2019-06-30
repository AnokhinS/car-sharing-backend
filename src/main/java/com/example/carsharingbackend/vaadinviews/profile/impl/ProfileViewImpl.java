package com.example.carsharingbackend.vaadinviews.profile.impl;

import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.utils.ComponentBuilder;
import com.example.carsharingbackend.utils.PageWrapper;
import com.example.carsharingbackend.vaadinviews.profile.ProfilePresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.context.annotation.Scope;

@SpringComponent
@Scope(value = "prototype")
public class ProfileViewImpl extends HorizontalLayout implements ProfilePresenter.ProfileView {

    private VerticalLayout userInfo;
    private User user;

    public ProfileViewImpl() {
        setSizeFull();
    }


    private VerticalLayout getUserInfo(User user){
        VerticalLayout info = new VerticalLayout();
        info.setWidth("300px");
        info.getStyle().set("margin-top", "100px");
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

    @Override
    public Component mainLayout() {
        return new PageWrapper(this);
    }

    @Override
    public void setUser(User user) {
        this.user = user;
        userInfo = getUserInfo(user);
        add(userInfo);
    }

    @Override
    public void setContent(Component content) {
        add(content);
    }


}
