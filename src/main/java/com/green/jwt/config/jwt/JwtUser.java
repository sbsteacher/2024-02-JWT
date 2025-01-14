package com.green.jwt.config.jwt;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode //Equals, HashCode 메소드 오버라이딩
public class JwtUser implements UserDetails {
    private long signedUserId;
    private List<String> roles; //인가(권한)처리 때 사용, ROLE_이름, ROLE_USER, ROLE_ADMIN

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>(roles.size());
//        for(String role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role));
//        }
//        return authorities;

        return roles.stream() //List<String>을 Stream<List<String>>으로 변환
                     // SimpleGrantedAuthority::new은 메소드 참조라고 호칭
                     // .map(item -> new SimpleGrantedAuthority(item))와 같은 내용이다.
                    .map(SimpleGrantedAuthority::new) //map은 똑같은 size의 스트림을 만든다. Stream<List<SimpleGrantedAuthority>>으로 변환,
                    .toList();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
