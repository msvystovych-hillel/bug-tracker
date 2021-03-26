package com.example.demo.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class TestRepository {

    //connection
    @Autowired
    private DataSource dataSource;

    //queries
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void testInsert() {
        Map<String, Object> params = new HashMap<>();
        params.put("ID", null);
        params.put("NAME", "@F");
        SimpleJdbcInsert insertData = new
                SimpleJdbcInsert(dataSource)
                .withTableName("user")
                .usingColumns("id", "name");
        insertData.execute(params);
    }

    public Long count() {
        return jdbcTemplate.queryForObject("select count(*) from user", Long.class);
    }


}
