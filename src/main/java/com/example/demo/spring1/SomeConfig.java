package com.example.demo.spring1;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SomeConfig {
    private final String url = "jdbc:mysql://localhost:3306/testDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final String username = "root";
    private final String password = "my-secret-pw";
    private final String driverClassName = "com.mysql.cj.jdbc.Driver";

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .username(username)
                .password(password)
                .url(url)
                .driverClassName(driverClassName)
                .build();
    }

}
