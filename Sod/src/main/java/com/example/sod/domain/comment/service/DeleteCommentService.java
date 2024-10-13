package com.example.sod.domain.comment.service;

import com.example.sod.domain.comment.domain.Comment;
import com.example.sod.domain.comment.domain.repository.CommentRepository;
import com.example.sod.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentService {

    private final CommentRepository commentRepository;

    public void execute(Long commentId) {
        // 댓글이 존재하는지 확인
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found with id: " + commentId));

        // 댓글 삭제
        commentRepository.delete(comment);
    }
}
