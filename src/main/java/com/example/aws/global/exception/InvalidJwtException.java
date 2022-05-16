package com.example.aws.global.exception;

import com.example.aws.global.error.exception.ErrorCode;
import com.example.aws.global.error.exception.ProjectException;

public class InvalidJwtException extends ProjectException {
    public static final InvalidJwtException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
