package com.forum.hub.domain.topic;

import java.time.LocalDateTime;

public record ReadTopicData(
    Long id,
    String title,
    String message,
    LocalDateTime creationDate) {

    public ReadTopicData(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate());
    }
}
