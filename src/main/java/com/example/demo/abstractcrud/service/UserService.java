package com.example.demo.abstractcrud.service;

import com.example.demo.abstractcrud.model.User;
import com.example.demo.abstractcrud.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService extends AbstractService<User, UserRepository> {

    public UserService(UserRepository repository) {
        super(repository);
    }

    @Override
    public Optional<User> save(User entity) {
        log.info("UserService.save() invoked");
        return Optional.of(repository.save(entity));
    }
}