package com.app.global.config.security;

import com.app.global.jwt.service.TokenManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Value(value = "${app.properties.jwt.secret}")
    private String secret;

    @Value(value = "${app.properties.jwt.access-token-expiration-time}")
    private String accessTokenExpirationTime;

    @Value(value = "${app.properties.jwt.refresh-token-expiration-time}")
    private String refreshTokenExpirationTime;

    @Bean
    public TokenManager tokenManager() {
        return new TokenManager(accessTokenExpirationTime, refreshTokenExpirationTime, secret);
    }


}
