package com.example.demo.exception;

import lombok.Getter;

@Getter
@SuppressWarnings("unused")
public class AbstractEntityExistsException extends AbstractException {

    public AbstractEntityExistsException(String messageCode, String message) {
        super(messageCode, message);
    }
}
