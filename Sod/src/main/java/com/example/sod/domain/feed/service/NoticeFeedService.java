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

        String filteredContent = filterContent(noticeFeedRequest.getContent());
        String filterTitle = filterTitle(noticeFeedRequest.getTitle());

        Feed feed = Feed.builder()
                .title(filterTitle)
                .content(filteredContent)
                .name(noticeFeedRequest.getName())
                .weather(noticeFeedRequest.getWeather())
                .day(noticeFeedRequest.getDay())
                .user(user)
                .build();
        feedRepository.save(feed);
    }

    private String filterContent(String content) {
        String[] badWords = {"씨발", "시발", "ㅅㅂ", "개새", "병신"};
        String filteredContent = content;
        for (String word : badWords) {
            filteredContent = filteredContent.replaceAll(word, "**");
        }
        return filteredContent;
    }

    private String filterTitle(String title) {
        String[] badWords = {"씨발", "시발", "ㅅㅂ", "개새", "병신"};
        String filteredTitle = title;
        for (String word : badWords) {
            filteredTitle = filteredTitle.replaceAll(word, "**");
        }
        return filteredTitle;
    }
}
