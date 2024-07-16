package com.forum.hub.domain.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findAllByActiveTrue(Pageable pagination);

    boolean existsByTitleAndMessage(String title, String message);
}
