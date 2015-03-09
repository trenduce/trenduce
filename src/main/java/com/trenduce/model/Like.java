package com.trenduce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trenduce.helper.Utils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by prafulmantale on 1/4/15.
 */

@Document
public class Like {

    @JsonProperty("uid")
    private String userId;

    public Like() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Like like = (Like) o;

        if (!userId.equals(like.userId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }

    @Override
    public String toString() {
        return "Like{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
