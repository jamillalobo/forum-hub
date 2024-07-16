package com.forum.hub.domain.topic.validations;

import com.forum.hub.domain.ValidateException;
import com.forum.hub.domain.topic.CreateTopicData;
import com.forum.hub.domain.topic.DetailTopicData;
import com.forum.hub.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DuplicationValidator implements TopicValidation {

    @Autowired
    private TopicRepository repository;

    @Override
    public void validate(CreateTopicData data) {
       var existTopic = repository.existsByTitleAndMessage(data.title(), data.message());
       if (existTopic) {
           throw new ValidateException("This topic already exists.");
       }
    }
}
