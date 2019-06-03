package com.example.carsharingbackend.common;

import com.example.carsharingbackend.restClients.RestClient;
import com.example.carsharingbackend.restClients.RestTransmissionClient;
import org.springframework.stereotype.Service;

@Service
public class TransmissionAttributeClient implements AttributeClient {
    private RestTransmissionClient client;

    public TransmissionAttributeClient(RestTransmissionClient client) {
        this.client = client;
    }

    @Override
    public RestClient getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Коробка передач";
    }
}
