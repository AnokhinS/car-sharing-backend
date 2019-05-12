package com.example.carsharingbackend.utils;

public class StringUtils {
    public static String firstToUpper(String str) {
        String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
        return cap;
    }
}
