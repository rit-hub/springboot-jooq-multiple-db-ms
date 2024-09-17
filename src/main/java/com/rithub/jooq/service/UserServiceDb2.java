//package com.rithub.jooq.service;
//
//import com.rithub.jooq.jooq_postgres.tables.Users;
//import com.rithub.jooq.jooq_postgres.tables.records.UsersRecord;
//import org.jooq.DSLContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserServiceDb2 {
//
//    private final DSLContext dsl;
//
//    @Autowired
//    public UserServiceDb2(@Qualifier("db2DslContext") DSLContext dsl) {
//        this.dsl = dsl;
//    }
//
//    public List<UsersRecord> getAllUsers() {
//        return dsl.selectFrom(Users.USERS).fetch();
//    }
//
//    public UsersRecord getUserById(int id) {
//        return dsl.selectFrom(Users.USERS)
//            .where(Users.USERS.ID.eq(id))
//            .fetchOne();
//    }
//
//    public void createUser(String username, String email) {
//        dsl.insertInto(Users.USERS)
//            .set(Users.USERS.USERNAME, username)
//            .set(Users.USERS.EMAIL, email)
//            .execute();
//    }
//}
