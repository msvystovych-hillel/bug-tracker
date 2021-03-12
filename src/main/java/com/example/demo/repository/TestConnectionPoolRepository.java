package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TestConnectionPoolRepository {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    public long count() {
        long id = -1L;
        Connection con = null;
        try {

            con = BasicConnectionPool.create(url, user, password).getConnection();
            PreparedStatement pr = con.prepareStatement("select count(*) as cc from user");
            ResultSet resultSet = pr.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getLong("cc");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return id;

        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
