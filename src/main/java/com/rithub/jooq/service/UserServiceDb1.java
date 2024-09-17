package com.rithub.jooq.service;

import org.jooq.DSLContext;
import org.jooq.impl.DefaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceDb1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceDb1.class);
    private final DSLContext dsl;

    @Autowired
    public UserServiceDb1(@Qualifier("db1DslContext") DSLContext dsl) {
        this.dsl = dsl;
        // Log the database connection URL for the read-only DB
        if (dsl != null) {
            try {
                // Get connection metadata from the DSLContext for the read-only DB
                DefaultConfiguration configuration = (DefaultConfiguration) dsl.configuration();
                String dbUrl = Objects.requireNonNull(configuration.connectionProvider().acquire()).getMetaData().getURL();
                String userName = Objects.requireNonNull(configuration.connectionProvider().acquire()).getMetaData().getUserName();
                LOGGER.info("Using read-only database connection URL: {}", dbUrl);
                LOGGER.info("Connected as read-only user: {}", userName);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            LOGGER.warn("DSLContext is null! Unable to log DB connection details.");
        }
    }

//    public List<jooq_practice.tables.records.UsersRecord> getAllUsers() {
//        return dsl.selectFrom(jooq_practice.tables.Users.USERS).fetch();
//    }
//
//    public jooq_practice.tables.records.UsersRecord getUserById(int id) {
//        return dsl.selectFrom(jooq_practice.tables.Users.USERS)
//            .where(jooq_practice.tables.Users.USERS.ID.eq(id))
//            .fetchOne();
//    }
//
//    public void createUser(String username, String email) {
//        dsl.insertInto(jooq_practice.tables.Users.USERS)
//            .set(jooq_practice.tables.Users.USERS.USERNAME, username)
//            .set(jooq_practice.tables.Users.USERS.EMAIL, email)
//            .execute();
//    }
}
