package com.app.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    //Authentication
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A-001", "Token Expired"),
    NOT_VALID_TOKEN(HttpStatus.UNAUTHORIZED, "A-002", "Invalid Token");

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

}
