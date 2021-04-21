package com.example.demo.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ConditionalOnClass(DataSource.class)
@Slf4j
public class MySQLAutoconfiguration {
//    @Bean
//    @ConditionalOnBean(name = "dataSourceLocalDependingOnVariable")
//    @ConditionalOnMissingBean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSourceLocalDependingOnVariable());
//        em.setPackagesToScan("com.example.demo");
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
////        if (additionalProperties() != null) {
////            em.setJpaProperties(additionalProperties());
////        }
//        return em;
//    }

    @Bean
    @ConditionalOnMissingBean(type = "JpaTransactionManager")
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
//    @ConditionalOnProperty(
//            name = "usemysql",
//            havingValue = "local")

    @ConditionalOnBean(name = "dataSource")
    @ConditionalOnMissingBean
    public DataSource dataSourceLocalDependingOnVariable() {
        log.info("Loaded a custom data source from MySQLAutoconfiguration");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("my-secret-pw");

        return dataSource;
    }

//    @Bean
//    @Profile("localMySqlProfile")
//    public DataSource dataSourceLocalDependingOnProfile() {
//        log.info("Loaded a custom data source from MySQLAutoconfiguration for profile localMySqlProfile");
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/testDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
//        dataSource.setUsername("root");
//        dataSource.setPassword("my-secret-pw");
//
//        return dataSource;
//    }

//    @Conditional(MySQLDatabaseTypeCondition.class)
//    public DataSource dataSourceLocalDependingOnCustomCondition() {
//        log.info("Loaded a custom data source from MySQLAutoconfiguration dataSourceLocalDependingOnCustomCondition()");
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/testDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
//        dataSource.setUsername("root");
//        dataSource.setPassword("my-secret-pw");
//
//        return dataSource;
//    }

//    @DatabaseType("MYSQL-LOCAL")
//    public DataSource dataSourceLocalDependingOnCustomAnnotation() {
//        log.info("Loaded a custom data source from MySQLAutoconfiguration dataSourceLocalDependingOnCustomAnnotation()");
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/testDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
//        dataSource.setUsername("root");
//        dataSource.setPassword("my-secret-pw");
//
//        return dataSource;
//    }
}
