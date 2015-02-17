package com.trenduce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trenduce.helper.Utils;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prafulmantale on 1/4/15.
 */
@Document(collection = "styles")
public class Collage {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("createBy")
    private String createdBy; //User id

    @JsonProperty("lastUpdated")
    private String lastUpdated; //Last updated

    @JsonProperty("title")
    private String title; //Collage Title

    @JsonProperty("image")
    private String imageUrl;

    @JsonIgnore
    private List<String> products; //Products used to create the style


    @JsonProperty("Price")
    private Price price; //Sell price of the style

    @JsonProperty("viewCount")
    private long viewCount; // Every time user clicks on this style

    @JsonProperty("likesCount")
    @Transient
    private long likesCount;

    @JsonProperty("commentsCount")
    @Transient
    private long commentsCount;

    //@JsonProperty("comments")
    @JsonIgnore
    private List<Comment> comments;

   // @JsonProperty("likes")
    @JsonIgnore
    private List<Like> likes;

    @JsonProperty("tags")
    private List<String> tags;

    public Collage() {

        comments = new ArrayList<Comment>();
        likes = new ArrayList<Like>();
        tags = new ArrayList<String>();
        lastUpdated = Utils.getFormattedCurrentTime();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public long getLikesCount() {

        return (likes != null) ? likes.size() : 0;
    }

    public void setLikesCount(long likesCount) {
        if(likes != null) {
            this.likesCount = likes.size();
        }
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public long getCommentsCount() {
        return (comments != null) ? comments.size() : 0;
    }

    public void setCommentsCount(long commentsCount) {

        if(comments != null) {
            this.commentsCount = comments.size();
        }
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
