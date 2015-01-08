package com.trenduce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by prafulmantale on 1/4/15.
 */
@Document(collection = "styles")
public class Collage {

    @Id
    private String id;
    private String createdBy; //User id
    private String lastUpdated; //Last updated
    private String title; //Collage Title

    private List<String> products; //Products used to create the style

    private Price price; //Sell price of the style

    private long viewCount; // Every time user clicks on this style
    private long likesCount;

    private List<Comment> comments;

    public Collage() {
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
        return likesCount;
    }

    public void setLikesCount(long likesCount) {
        this.likesCount = likesCount;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
