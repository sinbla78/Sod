package com.example.sod.domain.comment.controller;



import com.example.sod.domain.comment.controller.dto.request.CreateCommentRequest;
import com.example.sod.domain.comment.controller.dto.response.CreateCommentResponse;
import com.example.sod.domain.comment.service.CreateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/comments")
@RestController
public class CommentController {

    private final CreateCommentService createCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public CreateCommentResponse createComment(@PathVariable("feed-id") Long feedId, @RequestBody @Valid CreateCommentRequest request) {
        return createCommentService.execute(feedId, request);
    }

}
