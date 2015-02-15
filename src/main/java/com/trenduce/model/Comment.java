package com.trenduce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trenduce.helper.Utils;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by prafulmantale on 1/4/15.
 */

@Document
public class Comment {

    @JsonProperty("User")
    private String user;

    @JsonProperty("text")
    private String text;

    @JsonIgnore
    private long createdAt;

    @JsonProperty("createdAt")
    private String displayCreatedAt;

    public Comment() {

        createdAt = System.currentTimeMillis();
        displayCreatedAt = Utils.getFormattedCurrentTime();
    }

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
