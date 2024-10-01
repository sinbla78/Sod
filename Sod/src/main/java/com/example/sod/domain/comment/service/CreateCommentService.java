package com.example.sod.domain.comment.service;


import com.example.sod.domain.comment.domain.Comment;
import com.example.sod.domain.comment.domain.repository.CommentRepository;
import com.example.sod.domain.comment.controller.dto.request.CreateCommentRequest;
import com.example.sod.domain.comment.controller.dto.response.CreateCommentResponse;
import com.example.sod.domain.feed.domain.Feed;
import com.example.sod.domain.feed.domain.repository.FeedRepository;
import com.example.sod.domain.feed.exception.FeedNotFoundException;
import com.example.sod.domain.user.domain.User;
import com.example.sod.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCommentService {

    private final UserFacade userFacade;
    private final FeedRepository feedRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CreateCommentResponse execute(Long feedId, CreateCommentRequest request) {
        User user = userFacade.getCurrentUser();

        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        Comment comment = Comment.builder()
                .feed(feed)
                .user(user)
                .content(request.getContent())
                .build();

        commentRepository.save(comment);

        return new CreateCommentResponse(comment.getId(), comment.getContent(), comment.getCreatedAt());
    }
}
