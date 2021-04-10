package com.example.demo.repository;

import com.example.demo.exception.AbstractEntityExistsException;
import com.example.demo.exception.AbstractNotFoundException;
import com.example.demo.model.Role;
import com.example.demo.model.OldUser;
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
    public List<OldUser> getAllUsers() {
        TypedQuery<OldUser> fromUser = entityManager.createQuery("from User", OldUser.class);
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
        OldUser userToCreate = new OldUser();
        userToCreate.setName("New User");
        Role role = entityManager.find(Role.class, 1L);
        userToCreate.setRole(role);
        entityManager.persist(userToCreate);
    }
    public void testNotFoundException() {
        throw new AbstractNotFoundException("something.not.found.exception", "Something not found");
    }

    public void testExistsException() {
        throw new AbstractEntityExistsException("entity.exists.exception", "Something already exists");
    }
}
