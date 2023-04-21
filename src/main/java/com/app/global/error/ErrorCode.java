package com.app.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    //Authentication
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A-001", "Token Expired"),
    NOT_VALID_TOKEN(HttpStatus.UNAUTHORIZED, "A-002", "Invalid Token"),
    NOT_EXISTS_AUTHORIZATION(HttpStatus.UNAUTHORIZED, "A-003", "Not exists Authorization"),
    NOT_VALID_BEARER_GRANT_TYPE(HttpStatus.UNAUTHORIZED, "A-004", "Grant type is not bearer"),

    //    Member
    INVALID_MEMBER_TYPE(HttpStatus.BAD_REQUEST, "M-001", "Wrong Member Type");

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

}
