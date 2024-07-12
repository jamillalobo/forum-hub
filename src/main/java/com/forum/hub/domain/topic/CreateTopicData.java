package com.forum.hub.domain.topic;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateTopicData(
                            @NotBlank
                            String title,

                            @NotNull
                            String message,

                            @NotNull
                            @Future
                            LocalDateTime creationDate,

                            @NotBlank
                            TopicStatus topicStatus,

                            @NotBlank
                            String author,

                            @NotBlank
                            String course) {
}
