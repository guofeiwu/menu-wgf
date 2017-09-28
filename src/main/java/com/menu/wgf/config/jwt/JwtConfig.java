package com.menu.wgf.config.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
 * JWT配置读取
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    @Value("${jwt.headerKey}")
    private String headerKey;

    @Value("${jwt.tokenType}")
    private String tokenType;

    @Value("${jwt.clientId}")
    private String clientId;

    @Value("${jwt.signKey.app}")
    private String signKeyApp;

    @Value("${jwt.name}")
    private String name;

    @Value("${jwt.expiresMinute.App}")
    private int expiresMinuteApp;


    public String getHeaderKey() {
        return headerKey;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setHeaderKey(String headerKey) {
        this.headerKey = headerKey;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    public String getSignKeyApp() {
        return signKeyApp;
    }

    public void setSignKeyApp(String signKeyApp) {
        this.signKeyApp = signKeyApp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getExpiresMinuteApp() {
        return expiresMinuteApp;
    }

    public void setExpiresMinuteApp(int expiresMinuteApp) {
        this.expiresMinuteApp = expiresMinuteApp;
    }

}
