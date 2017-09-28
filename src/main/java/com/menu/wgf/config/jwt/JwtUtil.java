package com.menu.wgf.config.jwt;

import com.menu.wgf.Constants;
import com.menu.wgf.config.security.JwtUser;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guofei_wu on 2017/9/26.
 */

@Component
public class JwtUtil {

    @Autowired
    private JwtConfig jwtConfig;

    /**
     * 根据token获取用户信息
     */
    public static Claims getClaim(String token){
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("abcdefg")
                    .parseClaimsJws(token).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 设置用户信息进jwt
     */
    public static String setClaim(String subject){
        JwtBuilder builder = Jwts
                .builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "abcdefg");
        return builder.compact();
    }


    public Map.Entry<String, String> createJWTHeader(Map user) {
        final String headerKey = jwtConfig.getHeaderKey();
        final String tokenType = jwtConfig.getTokenType();

        String token = createJWT(user);

        HashMap<String, String> header = new HashMap<String, String>();
        //Bearer X.X.X
        header.put(headerKey, String.format("%s %s", tokenType, token));

        return header.entrySet().iterator().next();
    }

    /**
     * 生成token
     *
     * @param user
     * @return
     */
    public String createJWT(Map user) {
        long expMillis = 0;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationApp * 1000 * 60);

        if(expirationDate != null){
            expMillis = expirationDate.getTime();
        }

        return createJWT(user, expMillis);
    }

    @Value(value = "${jwt.signKey.app:menu_wuguofei_app}")
    private String signKeyApp;


    @Value("${jwt.expiresMinute.App}")
    private Long expirationApp;
    /**
     * 生成token,指定有效期
     *
     * @param user
     * @param expMillis
     * @return
     */
    public String createJWT(Map user, long expMillis) {

        String audience = jwtConfig.getClientId();
        String issuer = jwtConfig.getName();

        Integer userPkid = (Integer) user.get(Constants.LOGIN_PKID_KEY);
        String userLogin = (String) user.get(Constants.LOGIN_LOGIN_KEY);
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder()
                .setSubject(userLogin)
                .setHeaderParam("typ", "JWT")
                .setHeaderParam(Constants.LOGIN_PKID_KEY, userPkid)
                .setIssuer(issuer)
                .setAudience(audience)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, signKeyApp);

        //添加Token过期时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        Date exp = new Date(expMillis);

        builder.setExpiration(exp).setNotBefore(now);

        //生成JWT
        return builder.compact();
    }


    /**
     * 根据token获取用户名
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSignKeyApp())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }


    /**
     * 验证token
     * @param token
     * @param userDetails
     * @return
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        final String username = getUsernameFromToken(token);
        return (
                username.equals(user.getUsername())
                        && !isTokenExpired(token)
        );
    }

    /**
     * 判断token是否过期
     * @param token
     * @return
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 获取token的过期时间
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }





//    public Jws<Claims> parseJWT(String token) {
//        try {
//            String key = getSignKey();
//
//            Jws<Claims> jws = Jwts.parser().setSigningKey(key)
//                    .parseClaimsJws(token);
//            return jws;
//        } catch (SignatureException e) {
//            logger.debug("签名不正确");
//            return null;
//        } catch (ExpiredJwtException e) {
//            logger.debug("token过期");
//            return null;
//        } catch (Exception e) {
//            logger.debug(e.toString());
//            return null;
//        }
//    }




}
