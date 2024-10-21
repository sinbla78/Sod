package com.example.sod.domain.feed.service;

import com.example.sod.domain.feed.controller.dto.response.FeedListResponse;
import com.example.sod.domain.feed.domain.Feed;
import com.example.sod.domain.feed.domain.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedListService {

    private final FeedRepository feedRepository;

    // 전체 피드 목록을 반환
    public List<FeedListResponse> getFeedList() {
        List<Feed> feedList = feedRepository.findAll();

        // 피드 목록을 담을 리스트
        List<FeedListResponse> feedResponses = new ArrayList<>();

        for (Feed feed : feedList) {
            // 각 피드에 대한 정보를 추출하여 FeedResponse 객체로 변환
            FeedListResponse feedResponse = buildFeedResponse(feed);

            // 변환된 피드 정보를 리스트에 추가
            feedResponses.add(feedResponse);
        }

        return feedResponses;
    }

    // 제목으로 피드 검색
    public List<FeedListResponse> getFeedListByTitle(String title) {
        // 제목에 포함된 피드를 반환
        List<Feed> feedList = feedRepository.findByTitleContaining(title);

        // 피드 목록을 담을 리스트
        List<FeedListResponse> feedResponses = new ArrayList<>();

        for (Feed feed : feedList) {
            // 각 피드에 대한 정보를 추출하여 FeedResponse 객체로 변환
            FeedListResponse feedResponse = buildFeedResponse(feed);

            // 변환된 피드 정보를 리스트에 추가
            feedResponses.add(feedResponse);
        }

        return feedResponses;
    }

    // Feed 객체를 FeedListResponse로 변환하는 메서드
    private FeedListResponse buildFeedResponse(Feed feed) {
        return FeedListResponse.builder()
                .feedId(feed.getFeedId())
                .title(feed.getTitle())
                .content(feed.getContent())
                .weather(feed.getWeather())
                .day(feed.getDay())
                .name(feed.getName())
                .build();
    }
}

