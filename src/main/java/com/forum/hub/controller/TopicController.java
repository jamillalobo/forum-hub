package com.forum.hub.controller;

import com.forum.hub.domain.topic.*;
import com.forum.hub.domain.topic.validations.TopicValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("topics")
public class TopicController {

    @Autowired
    private TopicRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody CreateTopicData data, UriComponentsBuilder uriBuilder) {
        var topic = new Topic(data);
        repository.save(topic);
        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailTopicData(topic));
    }

    @GetMapping
    public ResponseEntity<Page<ReadTopicData>> listAll(@PageableDefault(size = 10, sort = {"title"}) Pageable pagination) {
        var page = repository.findAllByActiveTrue(pagination).map(ReadTopicData::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody UpdateTopicData data) {
        var topic = repository.getReferenceById(data.id());
        topic.updateInfos(data);
        return ResponseEntity.ok(topic);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var topic = repository.getReferenceById(id);
        topic.delete();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detailTopic(@PathVariable Long id) {
        var topic = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetailTopicData(topic));
    }
}
