package com.example.demo.abstractcrud.service;

import com.example.demo.abstractcrud.model.AbstractEntity;

import java.util.Optional;

public interface CommonService<E extends AbstractEntity> {
    Optional<E> save(E entity);
    Optional<Iterable<E>> getAll();
}