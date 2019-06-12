package com.example.carsharingbackend.restClients;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Collection;

public abstract class RestClient<T> {
    private RestTemplate template;

    protected String allUri;
    protected String oneUri;

    protected RestTemplate getTemplate(){
        if(template==null){
            template=new RestTemplate();
        }
        return template;
    }

    public abstract Collection<T> list(String filter);

    public abstract T getOne(long id);

    public abstract void update(long id, T entity);

    public abstract T create(T entity);

    public abstract void delete(long id);

    public abstract T newBean();
}
