package com.example.sod.domain.feed.service;

import com.example.sod.domain.feed.controller.dto.request.UpdateFeedRequest;
import com.example.sod.domain.feed.domain.Feed;
import com.example.sod.domain.feed.exception.CannotBeModifiedException;
import com.example.sod.domain.feed.facade.FeedFacade;
import com.example.sod.domain.user.domain.User;
import com.example.sod.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateFeedService {

    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void execute(Long feedId, UpdateFeedRequest updateFeedRequest) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedById(feedId);

        if (!user.equals(feed.getUser())) {
            throw CannotBeModifiedException.EXCEPTION;
        }

        // 필터링 및 교체
        String filteredTitle = filterAndReplace(updateFeedRequest.getTitle());
        String filteredContent = filterAndReplace(updateFeedRequest.getContent());
        // 추가 필드들도 필요에 따라 필터링 및 교체

        // 피드 업데이트
        feed.updateFeed(filteredTitle, filteredContent, updateFeedRequest.getWeather(), updateFeedRequest.getName(), updateFeedRequest.getDay());
    }

    // 필터링 및 교체 메서드
    private String filterAndReplace(String text) {
        // 필터링할 단어
        String badWord = "씨발";
        // 필터링 및 교체
        return text.replaceAll("(?i)\\b" + badWord + "\\b", "**");
    }
}

