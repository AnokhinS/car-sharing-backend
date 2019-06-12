package com.example.carsharingbackend.specifications;

import lombok.Getter;

@Getter
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
    private boolean isOr;

    public SearchCriteria() {
    }

    public SearchCriteria(String key, String operation, Object value, boolean isOr) {
        this.key = key;
        this.operation = operation;
        this.value = value;
        this.isOr = isOr;
    }
}

