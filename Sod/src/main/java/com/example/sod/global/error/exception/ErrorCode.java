package com.example.sod.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXPIRED_JWT(401, "Expired Token"),
    INVALID_JWT(401, "Invalid Token"),
    PASSWORD_MISMATCH(401, "Password Mismatch"),
    CANNOT_BE_DELETED(401, "Cannot Be Deleted"),
    CANNOT_BE_MODIFIED(401, "Cannot Be Modified"),

    USER_NOT_FOUND(404, "User Not Found"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),
    FEED_NOT_FOUUND(404, "Feed Not Found"),

    USER_EXISTS(409, "User Already Exists"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}
