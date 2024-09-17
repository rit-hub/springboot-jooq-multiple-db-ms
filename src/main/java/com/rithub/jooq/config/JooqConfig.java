package com.rithub.jooq.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JooqConfig {

    @Autowired
    @Qualifier("db1DataSource")
    private DataSource dataSource1;

    @Autowired
    @Qualifier("db2DataSource")
    private DataSource dataSource2;

    @Bean(name = "db1DslContext")
    public DSLContext dslContext1() {
        return DSL.using(dataSource1, SQLDialect.MYSQL);
    }

    @Bean(name = "db2DslContext")
    public DSLContext dslContext2() {
        return DSL.using(dataSource2, SQLDialect.POSTGRES);
    }
}

