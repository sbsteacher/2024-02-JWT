package com.green.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.jwt.config.constant.JwtConst;
import com.green.jwt.config.jwt.JwtUser;
import com.green.jwt.config.jwt.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

class System2 {
    static PrintStream out;
}

@SpringBootTest
class JwtApplicationTests {

    @Autowired
    private JwtConst jwtConst;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void enums() throws JsonProcessingException {
        List<UserRole> roles = Arrays.asList(UserRole.ADMIN, UserRole.USER);

        String json = objectMapper.writeValueAsString(roles);
        System.out.println(json);
    }

    @Test
    void enums2() throws JsonProcessingException {
        List<UserRole> roles = Arrays.asList(UserRole.ADMIN, UserRole.USER);
        JwtUser jwtUser = new JwtUser(1, roles);

        String json = objectMapper.writeValueAsString(jwtUser);
        System.out.println(json);
    }

    @Test
    void system_out_println() {
         PrintStream ps = System.out;
         System2.out.println();
    }

    @Test
    void objJwtConst() {
        System.out.println(jwtConst);
    }

}
