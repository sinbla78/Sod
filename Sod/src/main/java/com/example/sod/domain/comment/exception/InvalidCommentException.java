package com.example.decofolio.domain.comment.exception;

import com.example.decofolio.global.error.exception.CustomException;
import com.example.decofolio.global.error.exception.ErrorCode;

public class InvalidCommentException extends CustomException {

    public static final Exception EXCEPTION =
            new InvalidCommentException();

    private InvalidCommentException() {
        super(ErrorCode.INVALID_COMMENT);
    }

}
