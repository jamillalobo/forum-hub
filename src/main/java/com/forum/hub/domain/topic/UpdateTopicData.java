package com.forum.hub.domain.topic;

import jakarta.validation.constraints.NotNull;

public record UpdateTopicData(
        @NotNull
        Long id,
        String title,
        String message,
        String author,
        String course) {
}
