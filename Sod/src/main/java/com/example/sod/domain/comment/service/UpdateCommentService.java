package com.example.sod.domain.comment.service;

import com.example.sod.domain.comment.controller.dto.request.UpdateCommentRequest;
import com.example.sod.domain.comment.controller.dto.response.UpdateCommentResponse;
import com.example.sod.domain.comment.domain.Comment;
import com.example.sod.domain.comment.domain.repository.CommentRepository;
import com.example.sod.domain.comment.exception.CommentNotFoundException;
import com.example.sod.domain.comment.exception.CommentNotOwnedByUserException;
import com.example.sod.domain.user.domain.User;
import com.example.sod.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateCommentService {

    private final UserFacade userFacade;
    private final CommentRepository commentRepository;

    @Transactional
    public UpdateCommentResponse execute(Long commentId, UpdateCommentRequest request) {
        // 현재 사용자 가져오기
        User user = userFacade.getCurrentUser();

        // 수정할 댓글 찾기
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        // 현재 사용자와 댓글 작성자가 일치하는지 확인 (작성자만 수정 가능)
        if (!comment.getUser().equals(user)) {
            throw new CommentNotOwnedByUserException();
        }
        // 댓글 내용 수정
        comment.updateContent(request.getContent());

        // 수정된 댓글 저장 (변경 감지로 자동 저장)
        return new UpdateCommentResponse(comment.getId(), comment.getContent(), comment.getUpdatedAt());
    }
}

