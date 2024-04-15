package com.example.sod.domain.feed.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FeedListResponse {
    private Long feedId;
    private String title;
    private String content;
    private String weather;
    private String name;
    private String day;
}