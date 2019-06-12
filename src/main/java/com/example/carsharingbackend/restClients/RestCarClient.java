package com.example.carsharingbackend.restClients;

import com.example.carsharingbackend.entity.carinfo.CarEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class RestCarClient extends RestClient<CarEntity> {

    public RestCarClient() {
        super();
        allUri = "http://localhost:8080/restapi/cars";
        oneUri = "http://localhost:8080/restapi/cars/{id}";
    }

    @Override
    public Collection<CarEntity> list(String filter) {
        CarEntity[] objects = getTemplate().getForObject(allUri + filter, CarEntity[].class);
        return Arrays.asList(objects);
    }

    @Override
    public CarEntity getOne(long id) {
        return getTemplate().getForObject(oneUri, CarEntity.class, id);
    }

    @Override
    public void update(long id, CarEntity entity) {
        getTemplate().put(oneUri, entity, id);
    }

    @Override
    public CarEntity create(CarEntity entity) {
        return getTemplate().postForObject(allUri, entity, CarEntity.class);
    }

    @Override
    public void delete(long id) {
        getTemplate().delete(oneUri, id);
    }

    @Override
    public CarEntity newBean() {
        return new CarEntity();
    }

}


