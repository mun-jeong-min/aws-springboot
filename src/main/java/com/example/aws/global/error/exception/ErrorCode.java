package com.example.aws.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    UPLOAD_FILE_FAILED(400, "AUTH-400-1", "Upload File Failed"),

    PASSWORD_MISMATCH(401, "USER-401-1", "Password Mismatch"),

    USER_NOT_FOUND(404,"USER-404-1","User Not Found"),
    NOTICE_NOT_FOUND(404, "NOTICE-404-1", "Notice Not found"),
    REFRESH_TOKEN_NOT_FOUND(404, "jwt-404-1", "RefreshToken Not Found"),

    USER_EXIST(409,"USER-409-1","User Exist"),

    INVALID_JWT(401, "JWT-401-1", "Invalid Jwt"),
    EXPIRED_JWT(401,"JWT-401-1","Expired Jwt");

    private final int status;
    private final String code;
    private final String message;
}