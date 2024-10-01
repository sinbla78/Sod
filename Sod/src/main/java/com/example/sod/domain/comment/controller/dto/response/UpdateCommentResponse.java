package com.example.sod.domain.comment.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UpdateCommentResponse {
    private Long id;
    private String content;
    private LocalDateTime updatedAt;
}

