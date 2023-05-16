package com.app.api.login.validator;

import com.app.domain.member.entity.constant.MemberType;
import com.app.global.error.ErrorCode;
import com.app.global.error.exception.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class OAuthValidator {
    public void validateMemberType(String memberType){
        if(!MemberType.isMemberType(memberType)){
            throw new BusinessException(ErrorCode.INVALID_MEMBER_TYPE);
        }
    }
}
