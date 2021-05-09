package com.example.demo.abstractcrud.service;

import com.example.demo.abstractcrud.model.User;
import com.example.demo.abstractcrud.repository.UserRepository;
import com.example.demo.controller.IdNamePair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceFromAbstract extends AbstractService<User, UserRepository> {

    public UserServiceFromAbstract(UserRepository repository) {
        super(repository);
    }

    @Override
    public Optional<User> save(User entity) {
        log.info("UserService.save() invoked");
        return Optional.of(repository.save(entity));
    }

    @Override
    public Optional<Iterable<User>> getAll() {
        return Optional.of(repository.findAll());
    }

    public List<IdNamePair> getAllStubData() {
        Iterable<User> all = repository.findAll();
        return List.of(new IdNamePair("1", "John"), new IdNamePair("2", "Bob"));
    }
}