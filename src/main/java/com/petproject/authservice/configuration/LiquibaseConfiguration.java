package com.petproject.authservice.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfiguration {

    @Value("${spring.liquibase.change-log}")
    private String changeLog;

    @Bean
    public SpringLiquibase liquibase(final DataSource dataSource) {
        final SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setChangeLog(changeLog);
        springLiquibase.setDataSource(dataSource);

        return springLiquibase;
    }
}