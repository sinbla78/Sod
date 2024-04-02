package com.example.sod.domain.feed.domain.repository;

import com.example.sod.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
    Feed findByFeedId(Long feedId);
}
