package com.example.demo.configuration.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByLogin(String login);
}