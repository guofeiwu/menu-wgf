package com.menu.wgf.config.security;

import com.menu.wgf.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Jwt工厂类
 */
public final class JwtUserFactory {

    private JwtUserFactory() {}

    /**
     * 创建JwtUser工厂
     */
    public static JwtUser create(User user){
        return new JwtUser(
                user.gettUserPkid() == null ? 0 : user.gettUserPkid(),
                user.gettUserPhone(),
                user.gettUserPassword(),
                null
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}

