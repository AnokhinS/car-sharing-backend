package com.example.carsharingbackend.common;

import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.restClients.RestClient;

public interface AttributeClient {
    RestClient<NamedBean> getClient();
}
