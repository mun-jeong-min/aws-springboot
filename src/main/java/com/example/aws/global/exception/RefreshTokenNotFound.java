package com.example.aws.global.exception;

import com.example.aws.global.error.exception.ErrorCode;
import com.example.aws.global.error.exception.ProjectException;

public class RefreshTokenNotFound extends ProjectException {
    public static final RefreshTokenNotFound EXCEPTION =
            new RefreshTokenNotFound();

    public RefreshTokenNotFound() {
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}
