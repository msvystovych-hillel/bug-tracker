package com.example.demo.repository;

import com.example.demo.data.User;

import java.util.List;
import java.util.Optional;

// Repository - mechanism for encapsulating storage.
public interface AbstractRepository {
    List<User> getAll(); // возвращает все данные из таблицы
    void create();// добавляет одну запись
    Optional<User> get(int id);
    void update (User user, int id);
    void delete (int id);
}
