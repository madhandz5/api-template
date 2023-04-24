package com.app.api.login.service;

import com.app.api.login.dto.OAuthLoginDTO;
import com.app.domain.member.entity.Member;
import com.app.domain.member.entity.constant.MemberType;
import com.app.domain.member.entity.constant.Role;
import com.app.domain.member.service.MemberService;
import com.app.external.oauth.model.OAuthAttributes;
import com.app.external.oauth.service.SocialLoginApiService;
import com.app.external.oauth.service.SocialLoginApiServiceFactory;
import com.app.global.jwt.dto.JwtTokenDTO;
import com.app.global.jwt.service.TokenManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OAuthLoginService {

    private final MemberService memberService;
    private final TokenManager tokenManager;

    public OAuthLoginDTO.Response oAuthLogin(String accessToken, MemberType memberType) {
        SocialLoginApiService socialLoginApiService = SocialLoginApiServiceFactory.getSocialLoginApiService(memberType);
        OAuthAttributes userInfo = socialLoginApiService.getUserInfo(accessToken);
        JwtTokenDTO jwtTokenDTO;
        Optional<Member> optionalMember = memberService.findMemberByEmail(userInfo.getEmail());
        Member oauthMember;
        if (optionalMember.isEmpty()) {
            oauthMember = userInfo.toMemberEntity(memberType, Role.ADMIN);
            memberService.registerMember(oauthMember);
        } else {
            oauthMember = optionalMember.get();
        }
        jwtTokenDTO = tokenManager.createJwtTokenDTO(oauthMember.getId(), oauthMember.getRole());
        oauthMember.updateRefreshToken(jwtTokenDTO);
        return OAuthLoginDTO.Response.of(jwtTokenDTO);
    }
}
