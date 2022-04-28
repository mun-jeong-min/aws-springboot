package com.example.aws.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    NOTICE_NOT_FOUND(404, "NOTICE-404-1", "Notice not found");

    private final int status;
    private final String code;
    private final String message;
}
