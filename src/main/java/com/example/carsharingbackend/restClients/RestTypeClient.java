package com.example.carsharingbackend.restClients;

import com.example.carsharingbackend.entity.carinfo.TypeEntity;
import com.example.carsharingbackend.utils.UriBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class RestTypeClient extends RestClient<TypeEntity> {

    public RestTypeClient() {
        super();
        allUri = "http://localhost:8080/restapi/types";
        oneUri = "http://localhost:8080/restapi/types/{id}";
    }

    @Override
    public Collection<TypeEntity> list(String startsWith) {
        UriBuilder builder = new UriBuilder(allUri);
        builder.requestParam("startsWith", startsWith);
        TypeEntity[] objects = getTemplate().getForObject(builder.getUri(), TypeEntity[].class);
        return Arrays.asList(objects);
    }

    @Override
    public TypeEntity getOne(long id) {
        return getTemplate().getForObject(oneUri, TypeEntity.class, id);
    }

    @Override
    public void update(long id, TypeEntity entity) {
        getTemplate().put(oneUri, entity, id);
    }

    @Override
    public TypeEntity create(TypeEntity entity) {
        return getTemplate().postForObject(allUri, entity, TypeEntity.class);
    }

    @Override
    public void delete(long id) {
        getTemplate().delete(oneUri, id);
    }

    @Override
    public TypeEntity newBean() {
        return new TypeEntity();
    }

}


