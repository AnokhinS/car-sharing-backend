package com.example.carsharingbackend.security;

import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.restClients.RestUserClient;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Authorization {

    public static User currentUser() {
        RestUserClient userClient = new RestUserClient();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = null;
        for (User u : userClient.list(currentPrincipalName)){
            user=u;
        }
        return user;
    }
}
