package com.example.carsharingbackend.utils;

import java.util.ArrayList;
import java.util.Collection;

public class StringUtils {
    public static String firstToUpper(String str) {
        String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
        return cap;
    }

    public static Collection<String> toStringCollection(Collection collection){
        ArrayList<String> result=new ArrayList<>();
        collection.forEach(e->result.add(e.toString()));
        return result;
    }
    public static String toQueryParam(Collection<String> collection){
        String result="";
        for (String s:collection){
            result+=s+",";
        }
        return result.substring(0,result.length()-1);
    }
}
