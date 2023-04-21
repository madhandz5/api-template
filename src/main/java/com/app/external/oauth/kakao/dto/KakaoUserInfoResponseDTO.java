package com.app.external.oauth.kakao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
public class KakaoUserInfoResponseDTO {

    private String id;

    @JsonProperty(value = "kakao_account")
    private KakaoAccount kakaoAccount;


    @Data
    public static class KakaoAccount {
        private String email;
        private Profile profile;

        @Data
        public static class Profile {
            private String nickname;

            @JsonProperty(value = "thumbnail_image_url")
            private String thumbnailImageUrl;
        }
    }
}
