package com.example.demo.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ConditionalOnClass(DataSource.class)
@Slf4j
public class MySQLAutoconfiguration {
    @Bean
    @ConditionalOnBean(name = "spareDataSource")
    @ConditionalOnMissingBean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        log.info("----------Creating entityManagerFactory from MySQLAutoconfiguration");
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(spareDataSource());
        em.setPackagesToScan("com.example.demo");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    @ConditionalOnMissingBean(type = "jpaTransactionManager")
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        log.info("----------Creating transactionManager from MySQLAutoconfiguration");
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    @ConditionalOnBean(name = "dataSource")
    @ConditionalOnMissingBean
    public DataSource spareDataSource() {
        log.info("----------Loaded spareDataSource from MySQLAutoconfiguration");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("my-secret-pw");

        return dataSource;
    }

//    @ConditionalOnProperty(
//            name = "usemysql",
//            havingValue = "local")
//    @Conditional(MySQLDatabaseTypeCondition.class)
//    @Profile("localMySqlProfile")
//    @DatabaseType("MYSQL-LOCAL")


}
