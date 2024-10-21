package com.example.sod.domain.feed.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchFeedRequest {

    @NotNull(message = "제목은 Null이 될 수 없으며 최대 20자까지 가능합니다.")
    @Size(max = 20)
    private String title;

}