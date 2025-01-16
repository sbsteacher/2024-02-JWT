package com.green.jwt.user;

import com.green.jwt.user.model.UserSelOne;
import com.green.jwt.user.model.UserSignInReq;
import com.green.jwt.user.model.UserSignInRes;
import com.green.jwt.user.model.UserSignUpReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpReq req);
    int insUserRole(UserSignUpReq req);
    UserSelOne selUserWithRoles(UserSignInReq req);
}
