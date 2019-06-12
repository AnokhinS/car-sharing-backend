package com.example.carsharingbackend.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class OrderSumHelper {
    public static double getSum(LocalDate start, LocalDate end, double costPerDay) {
        return ChronoUnit.DAYS.between(start, end) * costPerDay;
    }
}
