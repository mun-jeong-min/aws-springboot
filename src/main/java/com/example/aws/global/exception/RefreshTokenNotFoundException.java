package com.example.aws.global.exception;

import com.example.aws.global.error.exception.ErrorCode;
import com.example.aws.global.error.exception.ProjectException;

public class RefreshTokenNotFoundException extends ProjectException {
    public static final RefreshTokenNotFoundException EXCEPTION =
            new RefreshTokenNotFoundException();

    public RefreshTokenNotFoundException() {
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}
