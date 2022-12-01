package com.example.plab.util.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
public class CommonResponse<T> {
    private Boolean isSuccess;
    private int responseCode;
    private String responseMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T responseResult;

    //요청 성공
    public CommonResponse(T result) {
        this.isSuccess = ResponseCode.SUCCESS.getIsSuccess();
        this.responseCode = ResponseCode.SUCCESS.getResponseCode();
        this.responseMessage = ResponseCode.SUCCESS.getResponseMessage();
        this.responseResult = result;
    }

    //요청 실패
    public CommonResponse(ResponseCode errorCode) {
        this.isSuccess = errorCode.getIsSuccess();
        this.responseCode = errorCode.getResponseCode();
        this.responseMessage = errorCode.getResponseMessage();
    }
}
