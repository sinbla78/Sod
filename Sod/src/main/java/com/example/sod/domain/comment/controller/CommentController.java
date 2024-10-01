package com.example.sod.domain.comment.controller;



import com.example.sod.domain.comment.controller.dto.request.CreateCommentRequest;
import com.example.sod.domain.comment.controller.dto.request.UpdateCommentRequest;
import com.example.sod.domain.comment.controller.dto.response.CreateCommentResponse;
import com.example.sod.domain.comment.controller.dto.response.UpdateCommentResponse;
import com.example.sod.domain.comment.service.CreateCommentService;
import com.example.sod.domain.comment.service.UpdateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/comments")
@RestController
public class CommentController {

    private final CreateCommentService createCommentService;
    private final UpdateCommentService updateCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public CreateCommentResponse createComment(@PathVariable("feed-id") Long feedId, @RequestBody @Valid CreateCommentRequest request) {
        return createCommentService.execute(feedId, request);
    }

    @ResponseStatus(HttpStatus.OK) // 성공적으로 수정되면 HTTP 200 상태 코드
    @PatchMapping("/{comment-id}") // 댓글 ID를 경로 변수로 받음
    public UpdateCommentResponse updateComment(
            @PathVariable("comment-id") Long commentId,
            @RequestBody @Valid UpdateCommentRequest request) {
        return updateCommentService.execute(commentId, request);
    }

}
