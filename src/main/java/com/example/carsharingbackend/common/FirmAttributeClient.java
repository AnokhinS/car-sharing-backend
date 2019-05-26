package com.example.carsharingbackend.common;

import com.example.carsharingbackend.restClients.RestFirmClient;
import com.example.carsharingbackend.restClients.RestNamedBeanClient;
import org.springframework.stereotype.Service;

@Service
public class FirmAttributeClient implements AttributeClient {
    private RestFirmClient client;

    public FirmAttributeClient(RestFirmClient client) {
        this.client = client;
    }

    @Override
    public RestNamedBeanClient getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Производитель";
    }
}
