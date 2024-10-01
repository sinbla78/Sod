package com.example.sod.domain.comment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN) // HTTP 403 Forbidden 상태 코드
public class CommentNotOwnedByUserException extends RuntimeException {

    public static final CommentNotOwnedByUserException EXCEPTION = new CommentNotOwnedByUserException();

    public CommentNotOwnedByUserException() {
        super("사용자가 댓글을 수정할 권한이 없습니다."); // 예외 메시지
    }
}
