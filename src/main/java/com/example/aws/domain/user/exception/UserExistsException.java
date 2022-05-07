package com.example.aws.domain.user.exception;

import com.example.aws.global.error.exception.ErrorCode;
import com.example.aws.global.error.exception.ProjectException;

public class UserExistsException extends ProjectException {
    public static UserExistsException EXCEPTION =
            new UserExistsException();

    public UserExistsException() {
        super(ErrorCode.USER_EXIST);
    }
}
