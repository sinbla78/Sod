package com.example.sod.domain.comment.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CreateCommentResponse {

    private Long commentId;
    private String content;
    private LocalDateTime createdAt; // 댓글 작성 시간 추가


    public CreateCommentResponse(Long commentId, String content, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
    }

}
