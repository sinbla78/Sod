package com.example.sod.domain.feed.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class NoticeFeedRequest {

    @NotNull(message = "제목은 Null이 될 수 없으며 최대 20자까지 가능합니다.")
    @Size(max = 20)
    private String title;

    @NotNull(message = "내용는 Null이 될 수 없으며 최대 1500자까지 가능합니다.")
    @Size(max = 1500)
    private String content;

    @NotNull(message = "이름은 Null이 될 수 없으며 최대 20자까지 가능합니다.")
    @Size(max = 20)
    private String name;

    @NotNull(message = "날씨는 Null이 될 수 없으며 최대 20자까지 가능합니다.")
    @Size(max = 20)
    private String weather;

    @NotNull(message = "날짜는 Null이 될 수 없으며 최대 20자까지 가능합니다.")
    @Size(max = 20)
    private String day;
}
