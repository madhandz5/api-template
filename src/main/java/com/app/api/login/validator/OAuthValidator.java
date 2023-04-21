package com.app.api.login.validator;

import com.app.domain.member.entity.constant.MemberType;
import com.app.global.error.ErrorCode;
import com.app.global.error.exception.AuthenticationException;
import com.app.global.error.exception.BusinessException;
import com.app.global.jwt.constant.GrantType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class OAuthValidator {

    public void validateAuthorization(String authorizationHeader) {

        if (!StringUtils.hasText(authorizationHeader)) {
            throw new AuthenticationException(ErrorCode.NOT_EXISTS_AUTHORIZATION);
        }

        String[] authorizations = authorizationHeader.split(" ");
        if (authorizations.length < 2 || (!GrantType.BEARER.getType().equals(authorizations[0]))) {
            throw new AuthenticationException(ErrorCode.NOT_VALID_BEARER_GRANT_TYPE);
        }
    }

    public void validateMemberType(String memberType){
        if(!MemberType.isMemberType(memberType)){
            throw new BusinessException(ErrorCode.INVALID_MEMBER_TYPE);
        }
    }

}
