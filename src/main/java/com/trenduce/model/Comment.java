package com.trenduce.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by prafulmantale on 1/4/15.
 */

@Document
public class Comment {

    private String user;
    private String text;
    private long createdAt;
    private String displayCreatedAt;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getDisplayCreatedAt() {
        return displayCreatedAt;
    }

    public void setDisplayCreatedAt(String displayCreatedAt) {
        this.displayCreatedAt = displayCreatedAt;
    }

}
