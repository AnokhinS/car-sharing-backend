package com.example.carsharingbackend.restClients;

import com.example.carsharingbackend.entity.carinfo.FirmEntity;
import com.example.carsharingbackend.utils.UriBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class RestFirmClient extends RestClient<FirmEntity> {

    public RestFirmClient() {
        super();
        allUri = "http://localhost:8080/restapi/firms";
        oneUri = "http://localhost:8080/restapi/firms/{id}";
    }

    public Collection<FirmEntity> list(String startsWith) {
        UriBuilder builder = new UriBuilder(allUri);
        builder.requestParam("startsWith", startsWith);
        ResponseEntity<FirmEntity[]> response = getTemplate().getForEntity(builder.getUri(), FirmEntity[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public FirmEntity getOne(long id) {
        return getTemplate().getForEntity(oneUri, FirmEntity.class, id).getBody();
    }

    @Override
    public void update(long id, FirmEntity entity) {
        getTemplate().put(oneUri, entity, id);
    }

    @Override
    public FirmEntity create(FirmEntity entity) {
        return getTemplate().postForEntity(allUri, entity, FirmEntity.class).getBody();
    }

    @Override
    public void delete(long id) {
        getTemplate().delete(oneUri, id);
    }

    @Override
    public FirmEntity newBean() {
        return new FirmEntity();
    }

}


