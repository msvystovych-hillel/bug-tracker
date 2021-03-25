package com.example.demo.repository;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TestJpaRepository {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<User> getAllUsers() {
        TypedQuery<User> fromUser = entityManager.createQuery("from User", User.class);
        fromUser.setLockMode(LockModeType.PESSIMISTIC_WRITE);
        return fromUser.getResultList();
    }

    @Transactional
    public List<Role> getAllRoles() {
        TypedQuery<Role> fromUser = entityManager.createQuery("from Role", Role.class);
        fromUser.setLockMode(LockModeType.PESSIMISTIC_WRITE);
        return fromUser.getResultList();
    }

    @Transactional
    public void saveUser() {
        User userToCreate = new User();
        userToCreate.setName("New User");
        Role role = entityManager.find(Role.class, 1L);
        userToCreate.setRole(role);
        entityManager.persist(userToCreate);
    }
}
