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
        BasicConnectionPool basicConnectionPool = null;
        Connection con = null;
        try {

            basicConnectionPool = BasicConnectionPool.create(url, user, password);
            con = basicConnectionPool.getConnection();
            PreparedStatement pr = con.prepareStatement("select count(*) as cc from user");
//            con.setAutoCommit();
//            con.setReadOnly();
//            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
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

        } finally {
            basicConnectionPool.releaseConnection(con);
        }
//        try {
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return id;
    }
}
