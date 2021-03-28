package com.example.demo.repository;

import com.example.demo.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.util.List;

// layer for db queries
@Repository
public class JdbcRepositoryImpl implements AbstractRepository {

    // JdbcTemplate- JDBC core package. Executes sql queries. iteration over ResultSet. catches JDBC exceptions.
    //RowMapper is callback i. (callee invokes code inside caller). Caller implements i., callee - invokes one of its methods
    @Autowired
    private JdbcTemplate jdbcTemplate;



    //mapper
    // ResultSet - table of data that represents a db result set. Maintains a cursor pointing to a row. Iterates only from 1st->last row.
    // RowMapper - f.i. Maps ResultSet to db row. used for JdbcTemplate query methods.
    private final RowMapper<User> mapper = (ResultSet resultSet, int rowNumber) ->
            //all fields must be mapped
            new User(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"));


    @Override
    public List<User> getAll() {
        List<User> users = jdbcTemplate.query("SELECT * FROM user_table", mapper);
        return users;
    }

    // PostConstruct - called once, after bean initialization. can't be static. Populates db.
    @PostConstruct
    @Override
    public void create() {

       jdbcTemplate.update("INSERT INTO user_table " + "VALUES (100,'Maria', 'Balter', 'maria.balter@mail.com')" );
    }
}
