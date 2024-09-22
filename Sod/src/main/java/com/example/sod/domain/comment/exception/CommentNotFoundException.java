package com.example.decofolio.domain.comment.exception;

import com.example.decofolio.global.error.exception.CustomException;
import com.example.decofolio.global.error.exception.ErrorCode;
public class CommentNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new CommentNotFoundException();

    private CommentNotFoundException() {
        super(ErrorCode.COMMENT_FOT_FOUND);
    }
}
