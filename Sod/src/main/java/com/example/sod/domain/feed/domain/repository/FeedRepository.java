package com.example.sod.domain.feed.domain.repository;

import com.example.sod.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Feed, Long> {
    Feed findByFeedId(Long feedId);

    List<Feed> findByTitleContaining(String title);
}
