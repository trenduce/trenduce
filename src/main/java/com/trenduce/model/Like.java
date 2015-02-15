package com.trenduce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trenduce.helper.Utils;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by prafulmantale on 1/4/15.
 */

@Document
public class Like {

    @JsonProperty("User")
    private String user;

    @JsonIgnore
    private long createdAt;

    @JsonProperty("createdAt")
    private String displayCreatedAt;

    public Like() {

        createdAt = System.currentTimeMillis();
        displayCreatedAt = Utils.getFormattedCurrentTime();
    }

    public Like(String user, String text){
        this();
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Like like = (Like) o;

        if (!user.equals(like.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }
}
