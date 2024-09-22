package com.example.decofolio.domain.comment.presentation.dto.response;



import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateCommentResponse {

    private Long commentId;
    private String content;

    public CreateCommentResponse(Long commentId, String content) {
        this.commentId = commentId;
        this.content = content;
    }

}
