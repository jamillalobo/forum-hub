package com.forum.hub.domain.topic;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DetailTopicData(

        Long id,

        String title,

        String message,

        LocalDateTime creationDate,

        TopicStatus topicStatus,

        String author,

        String course
) {
    public DetailTopicData(Topic topic) {
     this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getTopicStatus(), topic.getAuthor(), topic.getCourse());
    }
}
