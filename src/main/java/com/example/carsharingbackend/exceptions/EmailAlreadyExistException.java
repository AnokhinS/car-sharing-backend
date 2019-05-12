package com.example.carsharingbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistException extends Exception {
    public EmailAlreadyExistException() {
        super("Данный почтовый адрес занят");
    }
}
