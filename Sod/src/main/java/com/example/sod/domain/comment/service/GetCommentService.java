package com.example.sod.domain.comment.service;

import com.example.sod.domain.comment.controller.dto.response.CommentListResponse;
import com.example.sod.domain.comment.domain.repository.CommentRepository;
import com.example.sod.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetCommentService {

    private final CommentRepository commentRepository;

    public List<CommentListResponse> execute(Long feedId) {
        var comments = commentRepository.findByFeed_FeedId(feedId); // 피드 ID로 댓글 조회
        if (comments == null || comments.isEmpty()) {
            throw new CommentNotFoundException("No comments found for the given feed ID");
        }
        return comments.stream()
                .map(comment -> new CommentListResponse(comment.getId(), comment.getContent(), comment.getCreatedAt()))
                .collect(Collectors.toList());
    }
}
