package com.example.sod.domain.feed.service;

import com.example.sod.domain.feed.controller.dto.response.GetInfoDetailsResponse;
import com.example.sod.domain.feed.domain.Feed;
import com.example.sod.domain.feed.domain.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetInfoDetailsService {
    private final FeedRepository feedRepository;

    public GetInfoDetailsResponse getDetails(Long feedId) {

        Feed feed = feedRepository.findByFeedId(feedId);

        return new GetInfoDetailsResponse(
                feed.getName(),
                feed.getDay(),
                feed.getWeather(),
                feed.getTitle(),
                feed.getContent()
        );
    }
}
