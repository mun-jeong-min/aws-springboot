package com.example.aws.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    USER_NOT_FOUND(404,"USER-404-1","User Not Found"),
    NOTICE_NOT_FOUND(404, "NOTICE-404-1", "Notice Not found"),

    USER_EXIST(409,"USER-409-1","User Exist");

    private final int status;
    private final String code;
    private final String message;
}