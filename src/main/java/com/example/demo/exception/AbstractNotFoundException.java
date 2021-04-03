package com.example.demo.exception;

import lombok.Getter;

@Getter
@SuppressWarnings("unused")
public class AbstractNotFoundException extends AbstractException {

    public AbstractNotFoundException(String messageCode, String message) {
        super(messageCode, message);
    }
}
