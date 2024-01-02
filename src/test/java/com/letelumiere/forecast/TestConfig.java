package com.letelumiere.forecast;

import javax.sql.DataSource;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@TestConfiguration
@EnableJpaRepositories(basePackages = "com.letelumiere.forecast.repository")
public class TestConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @PersistenceContext
    private DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManager entityManager, DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.letelumiere.forecast.model");
        // Set other properties if needed
        return factoryBean;
    }
    @Bean
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
