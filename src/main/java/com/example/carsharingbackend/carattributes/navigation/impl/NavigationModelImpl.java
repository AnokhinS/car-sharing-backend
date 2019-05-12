package com.example.carsharingbackend.carattributes.navigation.impl;

import com.example.carsharingbackend.common.AttributeProvider;
import com.example.carsharingbackend.common.AttributeService;
import com.example.carsharingbackend.carattributes.navigation.NavigationPresenter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NavigationModelImpl implements NavigationPresenter.NavigationModel {
    private AttributeProvider provider;

    public NavigationModelImpl(AttributeProvider provider) {
        this.provider = provider;
    }

    @Override
    public List<AttributeService> getLinks() {
        return provider.getAttributes();
    }
}
