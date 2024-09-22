package com.example.decofolio.domain.comment.service;

import com.example.decofolio.domain.comment.domain.Comment;
import com.example.decofolio.domain.comment.domain.repository.CommentRepository;
import com.example.decofolio.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.decofolio.domain.comment.presentation.dto.response.CreateCommentResponse;
import com.example.decofolio.domain.feed.domain.Feed;
import com.example.decofolio.domain.feed.domain.repository.FeedRepository;
import com.example.decofolio.domain.feed.exception.FeedNotFoundException;
import com.example.decofolio.domain.user.domain.User;
import com.example.decofolio.domain.user.facade.UserFacade;
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

        return new CreateCommentResponse(comment.getId(), comment.getContent());
    }
}
