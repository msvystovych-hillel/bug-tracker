package com.example.demo.spring1;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SomeConfig {
//    @Value("${spring.datasource.url}")
    private String url = "jdbc:mysql://localhost:3306/testDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
//    @Value("${spring.datasource.username}")
    private String username = "root";
//    @Value("${spring.datasource.password}")
    private String password = "my-secret-pw";
//    @Value("${spring.datasource.driverClassName}")
    private String driverClassName = "com.mysql.cj.jdbc.Driver";

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
