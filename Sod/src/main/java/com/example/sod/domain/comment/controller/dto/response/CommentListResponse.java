package com.example.sod.domain.comment.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentListResponse {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
}
