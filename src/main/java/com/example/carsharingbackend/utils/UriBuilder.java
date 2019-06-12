package com.example.carsharingbackend.utils;

import lombok.Getter;

public class UriBuilder {
    @Getter
    private String uri;

    public UriBuilder(String uri) {
        this.uri = uri;
    }


    public void requestParam(String key, Object value) {
        if (value == null) {
            return;
        }
        String s;
        if (uri.contains("?")) {
            s = "&";
        } else {
            s = "?";
        }
        uri = uri + s + key + "=" + value.toString();
    }

}
