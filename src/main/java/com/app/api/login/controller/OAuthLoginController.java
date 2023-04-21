package com.app.api.login.controller;

import com.app.api.login.dto.OAuthLoginDTO;
import com.app.api.login.service.OAuthLoginService;
import com.app.api.login.validator.OAuthValidator;
import com.app.domain.member.entity.constant.MemberType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/oauth")
public class OAuthLoginController {

    private final OAuthLoginService oAuthLoginService;

    private final OAuthValidator oAuthValidator;

    @PostMapping(value = "/login")
    public ResponseEntity<OAuthLoginDTO.Response> oAuthLogin(@RequestBody OAuthLoginDTO.Request request, HttpServletRequest servletRequest) {
        String authorization = servletRequest.getHeader("Authorization");
        oAuthValidator.validateAuthorization(authorization);
        oAuthValidator.validateMemberType(request.getMemberType());
        String accessToken = authorization.split(" ")[1];
        OAuthLoginDTO.Response response = oAuthLoginService.oAuthLogin(accessToken, MemberType.from(request.getMemberType()));
        return ResponseEntity.ok(response);
    }


}
