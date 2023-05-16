package com.app.external.oauth.service;

import com.app.domain.member.entity.constant.MemberType;
import com.app.global.error.ErrorCode;
import com.app.global.error.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SocialLoginApiServiceFactory {

    private static Map<String, SocialLoginApiService> socialLoginApiServices;

    public SocialLoginApiServiceFactory(Map<String, SocialLoginApiService> socialLoginApiServices) {
        SocialLoginApiServiceFactory.socialLoginApiServices = socialLoginApiServices;
    }

    public static SocialLoginApiService getSocialLoginApiService(MemberType memberType) {
        String socialLoginApiServiceBeanName;
        switch (memberType) {
            case KAKAO:
                socialLoginApiServiceBeanName = "kakaoLoginApiServiceImpl";
                break;
            case NAVER:
                socialLoginApiServiceBeanName = "naverLoginApiServiceImpl";
                break;
            default:
                throw new BusinessException(ErrorCode.NOT_SUPPORTED_SERVICE);
        }
        return socialLoginApiServices.get(socialLoginApiServiceBeanName);
    }
}
