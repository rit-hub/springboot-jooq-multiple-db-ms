package com.rithub.jooq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "db1DataSource")
    @ConfigurationProperties("spring.datasource.db1")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2DataSource")
    @ConfigurationProperties("spring.datasource.db2")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }
}
