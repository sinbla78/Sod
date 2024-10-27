package com.example.sod.domain.comment.domain.repository;


import com.example.sod.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByFeed_FeedId(Long feedId); // Feed의 feedId를 기준으로 댓글을 조회
}
