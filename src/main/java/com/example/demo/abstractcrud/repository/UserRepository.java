package com.example.demo.abstractcrud.repository;

import com.example.demo.abstractcrud.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CommonRepository<User> {
}