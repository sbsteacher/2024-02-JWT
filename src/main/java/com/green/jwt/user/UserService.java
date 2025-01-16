package com.green.jwt.user;

import com.green.jwt.user.model.UserSignUpReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final TransactionTemplate transactionTemplate;

    public void signUp(UserSignUpReq req) {
        String hashedPw = passwordEncoder.encode(req.getPw());
        req.setPw(hashedPw);

        transactionTemplate.execute(status -> {
            userMapper.insUser(req);
            userMapper.insUserRole(req);
            return null;
        });
    }


}
