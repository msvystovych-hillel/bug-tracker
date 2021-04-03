package com.example.demo.exception;

import lombok.Getter;

@Getter
@SuppressWarnings("unused")
public class AbstractException extends RuntimeException {

    private final String messageCode;
    private final String message;

    public AbstractException(String messageCode, String message) {
        this.messageCode = messageCode;
        this.message = message;
    }
}
