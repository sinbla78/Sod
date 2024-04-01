package com.example.sod.domain.user.exception;

import com.example.sod.global.error.exception.CustomException;
import com.example.sod.global.error.exception.ErrorCode;

public class UserAlreadyExistsException extends CustomException {

    public static final UserAlreadyExistsException EXCEPTION =
            new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(ErrorCode.USER_EXISTS);
    }
}
