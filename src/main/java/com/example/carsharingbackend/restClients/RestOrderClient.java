package com.example.carsharingbackend.restClients;

import com.example.carsharingbackend.entity.Order;
import com.example.carsharingbackend.utils.UriBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class RestOrderClient extends RestClient<Order> {

    public RestOrderClient() {
        super();
        allUri = "http://localhost:8080/restapi/orders";
        oneUri = "http://localhost:8080/restapi/orders/{id}";
    }

    @Override
    public Collection<Order> list(String filter) {
        UriBuilder builder = new UriBuilder(allUri);
        builder.requestParam("user", filter);
        Order[] objects = getTemplate().getForObject(builder.getUri(), Order[].class);
        return Arrays.asList(objects);
    }

    @Override
    public Order getOne(long id) {
        return getTemplate().getForObject(oneUri, Order.class, id);
    }

    @Override
    public void update(long id, Order entity) {
        getTemplate().put(oneUri, entity, id);
    }

    @Override
    public Order create(Order entity) {
        return getTemplate().postForObject(allUri, entity, Order.class);
    }

    @Override
    public void delete(long id) {
        getTemplate().delete(oneUri, id);
    }

    @Override
    public Order newBean() {
        return new Order();
    }

}


