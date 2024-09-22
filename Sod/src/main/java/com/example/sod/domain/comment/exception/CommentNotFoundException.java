package com.example.sod.domain.comment.exception;


import com.example.sod.global.error.exception.CustomException;
import com.example.sod.global.error.exception.ErrorCode;

public class CommentNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new CommentNotFoundException();

    private CommentNotFoundException() {
        super(ErrorCode.COMMENT_FOT_FOUND);
    }
}
