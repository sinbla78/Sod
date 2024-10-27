package com.example.sod.domain.comment.domain;

import com.example.sod.domain.feed.domain.Feed;
import com.example.sod.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Length(max = 500)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    @Builder
    public Comment(String content, User user, Feed feed) {
        this.content = content;
        this.user = user;
        this.feed = feed;
        this.createdAt = LocalDateTime.now(); // 댓글 작성 시간 기록
        this.updatedAt = LocalDateTime.now(); // 댓글 수정 시간 기록 (처음엔 동일하게 설정)
    }

    public void updateContent(String newContent) {
        this.content = newContent;
        this.updatedAt = LocalDateTime.now(); // 수정 시간을 업데이트
    }

}
