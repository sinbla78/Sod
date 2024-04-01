package com.example.sod.domain.feed.exception;

import com.example.sod.global.error.exception.CustomException;
import com.example.sod.global.error.exception.ErrorCode;

public class CannotBeModifiedException extends CustomException {

    public static final CannotBeModifiedException EXCEPTION =
            new CannotBeModifiedException();

    private CannotBeModifiedException() {
        super(ErrorCode.CANNOT_BE_MODIFIED);
    }
}
