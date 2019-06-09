package com.example.carsharingbackend.entity.userinfo;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return toString();
    }
}
