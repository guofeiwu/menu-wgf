package com.menu.wgf.config.security;

import com.menu.wgf.config.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    /**
     * 这里注入的是前面写的UserDetailsService的实现类
     */
    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${jwt.headerKey}")
    private String tokenHeader;

    @Value("${jwt.tokenType}")
    private String tokenHead;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);  // 取得header
        if (authHeader != null && authHeader.startsWith(tokenHead)) {  //判断header头
            final String authToken = authHeader.substring(tokenHead.length()); // The part after "Bearer "
                String username = jwtUtil.getUsernameFromToken(authToken);//获取用户名
                logger.info("checking authentication " + username);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    // TODO: 2017/9/27 有空再看看
                    UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);  //验证jwt的信息是否正确
                    if (jwtUtil.validateToken(authToken, userDetails)) {
                        //将验证信息放入SecurityContextHolder中，UsernamePasswordAuthenticationToken是Security验证账号密码的工具类
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                                request));
                        logger.info("authenticated user " + username + ", setting security context");
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
        }

        chain.doFilter(request, response);
    }
}