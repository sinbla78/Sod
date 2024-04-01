package com.example.sod.global.exception;

import com.example.sod.global.error.exception.CustomException;
import com.example.sod.global.error.exception.ErrorCode;

public class ExpiredTokenException extends CustomException {

    public static final ExpiredTokenException EXCEPTION =
            new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}
