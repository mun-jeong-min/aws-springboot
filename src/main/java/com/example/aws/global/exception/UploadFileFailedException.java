package com.example.aws.global.exception;

import com.example.aws.global.error.exception.ErrorCode;
import com.example.aws.global.error.exception.ProjectException;

public class UploadFileFailedException extends ProjectException {
    public static UploadFileFailedException EXCEPTION =
            new UploadFileFailedException();

    public UploadFileFailedException() {
        super(ErrorCode.UPLOAD_FILE_FAILED);
    }
}
