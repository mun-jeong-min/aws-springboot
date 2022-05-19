package com.example.aws.global.exception;

import com.example.aws.global.error.exception.ErrorCode;
import com.example.aws.global.error.exception.ProjectException;

public class ExpiredJwtException extends ProjectException {
    public static ExpiredJwtException EXCEPTION =
            new ExpiredJwtException();

    public ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}
