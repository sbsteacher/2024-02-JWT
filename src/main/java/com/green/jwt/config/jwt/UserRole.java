package com.green.jwt.config.jwt;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

public enum UserRole {
      ROLE_ADMIN
    , ROLE_MENTOR
    , ROLE_USER;
}
