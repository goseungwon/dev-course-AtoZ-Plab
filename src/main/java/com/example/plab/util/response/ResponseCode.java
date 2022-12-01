package com.example.plab.util.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {
    //Success
    SUCCESS(true, HttpStatus.OK.value(), "요청에 성공하였습니다."),

    //Member
    EMAIL_ALREADY_USED(false, HttpStatus.BAD_REQUEST.value(), "이미 사용중인 email 입니다."),
    NOT_FOUND_MEMBER(false, HttpStatus.NOT_FOUND.value(), "존재하지 않는 member 입니다."),
    NOT_FOUND_GROUND(false, HttpStatus.NOT_FOUND.value(), "존재하지 않는 ground 입니다."),
    ;


    private final Boolean isSuccess;
    private final int responseCode;
    private final String responseMessage;

    ResponseCode(Boolean isSuccess, int responseCode, String responseMessage) {
        this.isSuccess = isSuccess;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }
}
