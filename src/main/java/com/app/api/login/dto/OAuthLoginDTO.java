package com.app.api.login.dto;

import com.app.global.jwt.dto.JwtTokenDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

public class OAuthLoginDTO {

    @Data
    public static class Request {
        private String memberType;
    }

    @Data
    @Builder
    public static class Response {
        private String grantType;
        private String accessToken;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private Date accessTokenExpireTime;
        private String refreshToken;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private Date refreshTokenExpireTime;

        public static Response of(JwtTokenDTO jwtTokenDTO) {
            return Response.builder()
                    .grantType(jwtTokenDTO.getGrantType())
                    .accessToken(jwtTokenDTO.getAccessToken())
                    .accessTokenExpireTime(jwtTokenDTO.getAccessTokenExpireTime())
                    .refreshToken(jwtTokenDTO.getRefreshToken())
                    .refreshTokenExpireTime(jwtTokenDTO.getRefreshTokenExpireTime())
                    .build();
        }

    }

}
