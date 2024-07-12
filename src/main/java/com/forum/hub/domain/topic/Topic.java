package com.forum.hub.domain.topic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String message;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "topic_status")
    private TopicStatus topicStatus;

    private String author;

    private String course;

    private Boolean active;

    public Topic(CreateTopicData data) {
        this.active = true;
        this.title = data.title();
        this.message = data.message();
        this.creationDate = data.creationDate();
        this.topicStatus = data.topicStatus();
        this.author = data.author();
        this.course = data.course();
    }

    public void updateInfos(UpdateTopicData data) {
        if (data.title() != null) {
            this.title = data.title();
        }
        if (data.message() != null) {
            this.message = data.message();
        }
        if (data.author() != null) {
            this.author = data.author();
        }
        if (data.course() != null) {
            this.course = data.course();
        }

    }

    public String getCourse() {
        return course;
    }

    public String getAuthor() {
        return author;
    }

    public TopicStatus getTopicStatus() {
        return topicStatus;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void delete() {
        this.active = false;
    }
}
