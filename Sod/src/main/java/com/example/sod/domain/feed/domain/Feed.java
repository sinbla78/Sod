package com.example.sod.domain.feed.domain;

import com.example.sod.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 1500, nullable = false)
    private String content;

    @Column(length = 20, nullable = false)
    private String weather;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String day;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Feed(String title, String content, String weather, String name, String day, User user) {
        this.title = title;
        this.content = content;
        this.weather = weather;
        this.name = name;
        this.day = day;
        this.user = user;
    }

    public void updateFeed(String title, String content, String weather, String name, String day) {
        this.title = title;
        this.content = content;
        this.weather = weather;
        this.name = name;
        this.day = day;
    }
}
