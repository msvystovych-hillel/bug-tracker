package com.example.demo.abstractcrud.controller;

import com.example.demo.abstractcrud.model.AbstractEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommonController<E extends AbstractEntity> {

    @PostMapping
    ResponseEntity<E> save(@RequestBody E entity);

}