package com.example.sod.domain.feed.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GetInfoDetailsResponse {
    private String name;
    private String day;
    private String weather;
    private String title;
    private String content;
}
