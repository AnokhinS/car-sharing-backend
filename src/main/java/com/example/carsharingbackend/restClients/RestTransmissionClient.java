package com.example.carsharingbackend.restClients;

import com.example.carsharingbackend.entity.carinfo.TransmissionEntity;
import com.example.carsharingbackend.utils.UriBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class RestTransmissionClient extends RestClient<TransmissionEntity> {

    public RestTransmissionClient() {
        super();
        allUri = "http://localhost:8080/restapi/transmissions";
        oneUri = "http://localhost:8080/restapi/transmissions/{id}";
    }

    @Override
    public Collection<TransmissionEntity> list(String startsWith) {
        UriBuilder builder = new UriBuilder(allUri);
        builder.requestParam("startsWith", startsWith);
        TransmissionEntity[] objects = getTemplate().getForObject(builder.getUri(), TransmissionEntity[].class);
        return Arrays.asList(objects);
    }

    @Override
    public TransmissionEntity getOne(long id) {
        return getTemplate().getForObject(oneUri, TransmissionEntity.class, id);
    }

    @Override
    public void update(long id, TransmissionEntity entity) {
        getTemplate().put(oneUri, entity, id);
    }

    @Override
    public TransmissionEntity create(TransmissionEntity entity) {
        return getTemplate().postForObject(allUri, entity, TransmissionEntity.class);
    }

    @Override
    public void delete(long id) {
        getTemplate().delete(oneUri, id);
    }

    @Override
    public TransmissionEntity newBean() {
        return new TransmissionEntity();
    }


}


