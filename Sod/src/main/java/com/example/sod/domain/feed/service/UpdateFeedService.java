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

        feed.updateFeed(updateFeedRequest.getTitle(), updateFeedRequest.getContent(), updateFeedRequest.getWeather(), updateFeedRequest.getName(), updateFeedRequest.getDay());
    }
}
