package com.menu.wgf.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity   //开启WebSecurity支持
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启prePostEnabled注解支持
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService jwtUserDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(jwtUserDetailsServiceImpl)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * 密码加密的bean，使用BCrypt
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 前置过滤器
     * @return
     */
    @Bean
    JwtAuthenticationTokenFilter authenticationTokenFilterBean(){
        return new JwtAuthenticationTokenFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()   
                .disable()  //禁用csrf保护
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)  //禁用session
                .and()
                .authorizeRequests()  //所有请求都要验证
                //.antMatchers("/auth/**").permitAll()  //登录注册等请求过滤
                .antMatchers(
                        HttpMethod.GET,
                        "/swagger*/**",
                        "/webjars/**",
                        "/v2/api-docs",
                        "/app/shai/all/*",
                        "/app/shai/comment/*/*",
                        "/app/shai/detail/*",
                        "/app/shai/look/*/shai/*",
                        "/app/menu/detail/*",
                        "/app/menu/comment/*/page/*",
                        "/app/menu/banner",
                        "/app/system/checkUpdate",
                        "/app/menu/record/*",
                        "/app/menu/likeRank",
                        "/app/menu/collectRank",
                        "/app/menu/lookRank/*",
                        "/app/menu/thematic/*",
                        "/app/menu/random"
                ).permitAll()
                .antMatchers(
                        HttpMethod.POST,
                        "/login/**",
                        "/app/menu/all",
                        "/app/system/feedback",
                        "/app/menu/thematic"
                ).permitAll()
                .anyRequest().authenticated()
               // .anyRequest().fullyAuthenticated()
                .and()
                .exceptionHandling()  //验证不通过的配置
                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
                ;
        http   //添加前置过滤器
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        http   //禁用header缓存
                .headers().cacheControl();
    }
}