package com.example.carsharingbackend.carattributes.navigation.impl;

import com.example.carsharingbackend.carattributes.navigation.NavigationPresenter;
import com.example.carsharingbackend.common.AttributeClient;
import com.example.carsharingbackend.common.AttributeProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
