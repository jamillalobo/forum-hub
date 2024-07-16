package com.forum.hub.domain.topic.validations;

import com.forum.hub.domain.topic.CreateTopicData;
import com.forum.hub.domain.topic.DetailTopicData;

public interface TopicValidation {
    void validate(CreateTopicData data);
}
