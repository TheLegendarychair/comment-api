package com.example.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
public class Score {

    @Id
    private String userSignature;


    private Long score;
    private LocalDateTime timeStamp;

    public Score() {}


    public Score(Long score, String userSignature,LocalDateTime timeStamp) {
        this.score = score;
        this.userSignature = userSignature;
        this.timeStamp = timeStamp;

    }

    public Long getScore() {
        return score;
    }
    public void setScore(Long score) {
        this.score = score;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
