package com.example.sod.domain.comment.exception;


import com.example.sod.global.error.exception.CustomException;
import com.example.sod.global.error.exception.ErrorCode;

public class InvalidCommentException extends CustomException {

    public static final Exception EXCEPTION =
            new InvalidCommentException();

    private InvalidCommentException() {
        super(ErrorCode.INVALID_COMMENT);
    }

}
