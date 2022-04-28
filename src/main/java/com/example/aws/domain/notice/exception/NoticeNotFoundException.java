package com.example.aws.domain.notice.exception;

import com.example.aws.global.error.exception.ErrorCode;
import com.example.aws.global.error.exception.ProjectException;

public class NoticeNotFoundException extends ProjectException {
    public static NoticeNotFoundException EXCEPTION =
            new NoticeNotFoundException();

    public NoticeNotFoundException() {
        super(ErrorCode.NOTICE_NOT_FOUND);
    }
}
