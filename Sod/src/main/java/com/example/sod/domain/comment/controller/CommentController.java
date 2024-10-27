package com.example.sod.domain.comment.controller;



import com.example.sod.domain.comment.controller.dto.request.CreateCommentRequest;
import com.example.sod.domain.comment.controller.dto.request.UpdateCommentRequest;
import com.example.sod.domain.comment.controller.dto.response.CommentListResponse;
import com.example.sod.domain.comment.controller.dto.response.CreateCommentResponse;
import com.example.sod.domain.comment.controller.dto.response.UpdateCommentResponse;
import com.example.sod.domain.comment.service.CreateCommentService;
import com.example.sod.domain.comment.service.DeleteCommentService;
import com.example.sod.domain.comment.service.GetCommentService;
import com.example.sod.domain.comment.service.UpdateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/comments")
@RestController
public class CommentController {

    private final CreateCommentService createCommentService;
    private final UpdateCommentService updateCommentService;
    private final DeleteCommentService deleteCommentService;
    private final GetCommentService getCommentService; // 추가된 서비스


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/feed/{feed-id}")
    public List<CommentListResponse> getComments(@PathVariable("feed-id") Long feedId) {
        return getCommentService.execute(feedId); // 댓글 목록 반환
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public CreateCommentResponse createComment(@PathVariable("feed-id") Long feedId, @RequestBody @Valid CreateCommentRequest request) {
        return createCommentService.execute(feedId, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{comment-id}")
    public UpdateCommentResponse updateComment(
            @PathVariable("comment-id") Long commentId,
            @RequestBody @Valid UpdateCommentRequest request) {
        return updateCommentService.execute(commentId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 삭제 요청 성공 시 204 상태 코드 반환
    @DeleteMapping("/{comment-id}")
    public void deleteComment(@PathVariable("comment-id") Long commentId) {
        deleteCommentService.execute(commentId); // 삭제 로직 실행
    }

}
