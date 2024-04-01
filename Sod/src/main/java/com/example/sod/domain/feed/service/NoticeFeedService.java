package com.example.sod.domain.feed.service;

import com.example.sod.domain.feed.controller.dto.request.NoticeFeedRequest;
import com.example.sod.domain.feed.domain.Feed;
import com.example.sod.domain.feed.domain.repository.FeedRepository;
import com.example.sod.domain.user.domain.User;
import com.example.sod.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NoticeFeedService {

    private final UserFacade userFacade;
    private final FeedRepository feedRepository;

    @Transactional
    public void execute(NoticeFeedRequest noticeFeedRequest) {
        User user = userFacade.getCurrentUser();

        Feed feed = Feed.builder()
                .title(noticeFeedRequest.getTitle())
                .content(noticeFeedRequest.getContent())
                .name(noticeFeedRequest.getName())
                .weather(noticeFeedRequest.getWeather())
                .day(noticeFeedRequest.getDay())
                .user(user)
                .build();
        feedRepository.save(feed);
    }
}
