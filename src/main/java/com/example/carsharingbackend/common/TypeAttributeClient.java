package com.example.carsharingbackend.common;

import com.example.carsharingbackend.restClients.RestClient;
import com.example.carsharingbackend.restClients.RestTypeClient;
import org.springframework.stereotype.Service;

@Service
public class TypeAttributeClient implements AttributeClient {
    private RestTypeClient client;

    public TypeAttributeClient(RestTypeClient client) {
        this.client = client;
    }

    @Override
    public RestClient getClient() {
        return client;
    }
    @Override
    public String toString() {
        return "Тип автомобиля";
    }
}
