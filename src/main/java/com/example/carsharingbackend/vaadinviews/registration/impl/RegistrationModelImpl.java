package com.example.carsharingbackend.vaadinviews.registration.impl;

import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.restClients.RestUserClient;
import com.example.carsharingbackend.vaadinviews.registration.RegistrationPresenter;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringComponent
public class RegistrationModelImpl implements RegistrationPresenter.RegistrationModel {

    RestUserClient client;
    PasswordEncoder passwordEncoder;

    public RegistrationModelImpl(RestUserClient client, PasswordEncoder passwordEncoder) {
        this.client = client;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        client.create(user);
    }
}
