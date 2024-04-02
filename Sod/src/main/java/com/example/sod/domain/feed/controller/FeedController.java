package com.example.sod.domain.feed.controller;

import com.example.sod.domain.feed.controller.dto.request.NoticeFeedRequest;
import com.example.sod.domain.feed.controller.dto.request.UpdateFeedRequest;
import com.example.sod.domain.feed.service.DeleteFeedService;
import com.example.sod.domain.feed.service.NoticeFeedService;
import com.example.sod.domain.feed.service.UpdateFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final NoticeFeedService noticeFeedService;
    private final DeleteFeedService deleteFeedService;
    private final UpdateFeedService updateFeedService;
    //일기 작성
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void noticeFeed(@RequestBody @Valid NoticeFeedRequest noticeFeedRequest) {
        noticeFeedService.execute(noticeFeedRequest);
    }

    //일기 삭제
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Long feedId) {
        deleteFeedService.execute(feedId);
    }

    //일기 수정
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{feed-id}")
    public void updateFeed(@PathVariable("feed-id") Long feedId, @RequestBody @Valid UpdateFeedRequest updateFeedRequest) {
        updateFeedService.execute(feedId, updateFeedRequest);
    }
}
