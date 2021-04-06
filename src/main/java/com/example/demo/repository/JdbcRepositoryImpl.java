package com.example.demo.repository;

import com.example.demo.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

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
        String selectAllQuery = "SELECT * FROM user_table";
        return jdbcTemplate.query(selectAllQuery, mapper);
    }

    // PostConstruct - called once, after bean initialization. can't be static. Populates db.
    @PostConstruct
    @Override
    public void create() {
        //TODO User as a parameter
        String addUserQuery = "INSERT INTO user_table (id, first_name, last_name, email) VALUES " +
                "(?,?,?,?);";
        jdbcTemplate.update(addUserQuery, 24, "Bill", "Musk", "bill.musk@mail.com");
    }

    @Override
    public Optional<User> get(int id) {
        String getUserQuery = "SELECT id, first_name, last_name, email FROM user_table WHERE id = ?;";
        User user = null;
        // queryForObject() return single object
        user = jdbcTemplate.queryForObject(getUserQuery, mapper, id);
        return Optional.ofNullable(user);
    }

    @Override
    public void update(User user, int id) {
        String updateUserQuery = "UPDATE user_table SET first_name = ?, last_name = ?, email = ?, WHERE id = ?;";
        jdbcTemplate.update(updateUserQuery, user.getFirstName(), user.getLastName(), user.getEmail(), id);
    }

    @Override
    public void delete(int id) {
        String deleteUserQuery = "DELETE FROM user_table WHERE id = ?;";
        jdbcTemplate.update(deleteUserQuery, id);
    }
}
