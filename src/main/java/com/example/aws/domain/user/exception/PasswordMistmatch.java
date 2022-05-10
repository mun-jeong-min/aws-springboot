package com.example.aws.domain.user.exception;

import com.example.aws.global.error.exception.ErrorCode;
import com.example.aws.global.error.exception.ProjectException;

public class PasswordMistmatch extends ProjectException {

    public static PasswordMistmatch EXCEPTION =
            new PasswordMistmatch();

    public PasswordMistmatch() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
