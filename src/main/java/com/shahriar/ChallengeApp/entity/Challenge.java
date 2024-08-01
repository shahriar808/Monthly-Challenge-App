package com.shahriar.ChallengeApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Challenge {
    @Id
    private Long id;
    private String title;
    private String description;

    public Challenge() {}
    public Challenge(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
