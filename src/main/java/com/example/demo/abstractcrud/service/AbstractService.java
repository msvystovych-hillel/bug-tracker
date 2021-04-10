package com.example.demo.abstractcrud.service;

import com.example.demo.abstractcrud.model.AbstractEntity;
import com.example.demo.abstractcrud.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>>
        implements CommonService<E> {

    protected final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }

}