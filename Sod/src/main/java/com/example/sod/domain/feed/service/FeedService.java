package com.example.sod.domain.feed.service;

import com.example.sod.domain.feed.controller.dto.response.FeedResponse;
import com.example.sod.domain.feed.domain.Feed;
import com.example.sod.domain.feed.domain.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedService {

    private final FeedRepository feedRepository;

    public List<FeedResponse> getFeedList() {
        List<Feed> feedList = feedRepository.findAll();

        // 피드 목록을 담을 리스트
        List<FeedResponse> feedResponses = new ArrayList<>();

        for (Feed feed : feedList) {
            // 각 피드에 대한 정보를 추출하여 FeedResponse 객체로 변환
            FeedResponse feedResponse = buildFeedResponse(feed);

            // 변환된 피드 정보를 리스트에 추가
            feedResponses.add(feedResponse);
        }

        return feedResponses;
    }

    private FeedResponse buildFeedResponse(Feed feed) {
        // 피드 정보를 FeedResponse 객체로 변환하여 반환
        return FeedResponse.builder()
                .feedId(feed.getFeedId())
                .title(feed.getTitle())
                .content(feed.getContent())
                .weather(feed.getWeather())
                .day(feed.getDay())
                .name(feed.getName())
                .build();
    }
}
