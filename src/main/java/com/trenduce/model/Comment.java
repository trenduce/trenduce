package com.trenduce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trenduce.helper.Utils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Created by prafulmantale on 1/4/15.
 */

@Document
public class Comment {

    @Field(value = "uid")
    @JsonProperty("uid")
    private String userId;

    @Field(value = "fn")
    @JsonProperty("fn")
    private String firstName;

    @Field(value = "ln")
    @JsonProperty("ln")
    private String lastName;

    @Field(value = "img")
    @JsonProperty("img")
    private String imageUrl;

    @Field(value = "text")
    @JsonProperty("text")
    private String text;

    @Field(value = "dt")
    @JsonProperty("dt")
    private Date createdAt;

    public Comment() {

        createdAt = new Date();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
