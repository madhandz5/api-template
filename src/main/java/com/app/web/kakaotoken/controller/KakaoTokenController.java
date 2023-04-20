package com.app.web.kakaotoken.controller;

import com.app.web.kakaotoken.client.KakaoTokenClient;
import com.app.web.kakaotoken.dto.KakaoTokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class KakaoTokenController {

    private final KakaoTokenClient kakaoTokenClient;

    @Value(value = "${app.properties.kakao.client.id}")
    private String clientId;

    @Value(value = "${app.properties.kakao.client.secret}")
    private String clientSecret;

    @Value(value = "${app.properties.kakao.redirect}")
    private String redirectHost;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @ResponseBody
    @GetMapping(value = "/oauth/kakao/callback")
    public String loginCallback(String code) {
        String contentType = "application/x-www-form-urlencoded;charset=utf-8";
        KakaoTokenDTO.Request kakaoTokenRequestdto = KakaoTokenDTO.Request.builder()
                .client_id(clientId)
                .client_secret(clientSecret)
                .grant_type("authorization_code")
                .code(code)
                .redirect_uri(redirectHost + "/oauth/kakao/callback")
                .build();
        KakaoTokenDTO.Response response = kakaoTokenClient.requestKakaoToken(contentType, kakaoTokenRequestdto);
        return "Kakao Token : " + response;
    }


}
