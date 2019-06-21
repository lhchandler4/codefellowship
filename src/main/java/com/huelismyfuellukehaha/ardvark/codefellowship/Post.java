package com.huelismyfuellukehaha.ardvark.codefellowship;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    public AppUser getCreator() {
        return creator;
    }

    public void setCreator(AppUser creator) {
        this.creator = creator;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Post(){}
    public Post(String body, AppUser creator){
        this.body = body;
        this.creator = creator;
        this.createdAt = LocalDateTime.now();
    }

    @ManyToOne
    AppUser creator;
    String body;
    LocalDateTime createdAt;
}
