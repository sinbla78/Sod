package com.example.sod.domain.feed.exception;

import com.example.sod.global.error.exception.CustomException;
import com.example.sod.global.error.exception.ErrorCode;

public class CannotBeDeletedException extends CustomException {

    public static final CannotBeDeletedException EXCEPTION =
            new CannotBeDeletedException();

    private CannotBeDeletedException() {
        super(ErrorCode.CANNOT_BE_DELETED);
    }
}
