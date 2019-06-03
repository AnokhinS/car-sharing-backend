package com.example.carsharingbackend.vaadinviews.admin.carattributes.navigation.impl;

import com.example.carsharingbackend.common.AttributeClient;
import com.example.carsharingbackend.common.AttributeProvider;
import com.example.carsharingbackend.vaadinviews.admin.carattributes.navigation.NavigationPresenter;
import com.vaadin.flow.spring.annotation.SpringComponent;

import java.util.List;

@SpringComponent
public class NavigationModelImpl implements NavigationPresenter.NavigationModel {
    private AttributeProvider provider;

    public NavigationModelImpl(AttributeProvider provider) {
        this.provider = provider;
    }

    @Override
    public List<AttributeClient> getLinks() {
        return provider.getAttributes();
    }
}
