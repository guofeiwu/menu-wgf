package com.menu.wgf.config.security;

import com.menu.wgf.model.User;
import com.menu.wgf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = new User(); //调用持久层获取
        user.settUserPhone(login);//这个login是有值的

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", login));
        } else {
            JwtUser jwtUser = JwtUserFactory.create(user);
            return jwtUser;
        }
    }
}
