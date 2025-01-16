package com.green.jwt.user;

import com.green.jwt.user.model.UserSelOne;
import com.green.jwt.user.model.UserSignInReq;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.junit.jupiter.api.Assertions.*;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void selUserWithRoles() {
        UserSignInReq req = new UserSignInReq("dd2d@naver.com", "");
        UserSelOne userSelOne = userMapper.selUserWithRoles(req);
        System.out.println(userSelOne);
    }
}