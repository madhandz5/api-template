package com.app.external.oauth.kakao.client;

import com.app.external.oauth.kakao.dto.KakaoUserInfoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://kapi.kakao.com", name = "kakaoUserInfoClient")
public interface KakaoUserInfoClient {

    @GetMapping(value = "/v2/user/me", consumes = MediaType.APPLICATION_JSON_VALUE)
    KakaoUserInfoResponseDTO getKakaoUserInfo(@RequestHeader(value = "Content-type") String contentType,
                                              @RequestHeader(value = "Authorization") String accessToken);

}
