package com.example.aws.domain.user.exception;

import com.example.aws.global.error.exception.ErrorCode;
import com.example.aws.global.error.exception.ProjectException;

public class UserNotFoundException extends ProjectException {
    public static UserNotFoundException EXCEPTION =
            new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
