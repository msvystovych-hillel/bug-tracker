package com.example.demo.repository;

import com.example.demo.data.User;

import java.util.List;

// Repository - mechanism for encapsulating storage.
public interface AbstractRepository {
    List<User> getAll(); // возвращает все данные из таблицы
    void create();// добавляет одну запись
}
