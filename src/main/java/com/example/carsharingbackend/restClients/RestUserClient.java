package com.example.carsharingbackend.restClients;

import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.utils.UriBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class RestUserClient extends RestClient<User> {

    public RestUserClient() {
        super();
        allUri = "http://localhost:8080/restapi/users";
        oneUri = "http://localhost:8080/restapi/users/{id}";
    }

    @Override
    public Collection<User> list(String startsWith) {
        UriBuilder builder = new UriBuilder(allUri);
        builder.requestParam("startsWith", startsWith);
        User[] objects = getTemplate().getForObject(builder.getUri(), User[].class);
        return Arrays.asList(objects);
    }

    @Override
    public User getOne(long id) {
        return getTemplate().getForObject(oneUri, User.class, id);
    }

    @Override
    public void update(long id, User entity) {
        getTemplate().put(oneUri, entity, id);
    }

    @Override
    public User create(User entity) {
        return getTemplate().postForObject(allUri, entity, User.class);
    }

    @Override
    public void delete(long id) {
        getTemplate().delete(oneUri, id);
    }

    @Override
    public User newBean() {
        return new User();
    }

}


