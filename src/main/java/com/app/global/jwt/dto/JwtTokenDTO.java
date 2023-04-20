package com.app.global.jwt.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtTokenDTO {

    private String grantType;
    private String accessToken;
    private Date accessTokenExpireTime;
    private String refreshToken;
    private Date refreshTokenExpireTime;

}
