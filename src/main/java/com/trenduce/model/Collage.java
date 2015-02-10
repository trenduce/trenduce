package com.trenduce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
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
    private long likesCount;

    @JsonProperty("comments")
    private List<Comment> comments;

    public Collage() {
        id = "1234";
        createdBy = "Mr Kumar";
        lastUpdated = "15-Jan-2015";
        title = "What a style";
        imageUrl = "http://media.style.com/image/slideshows/editors/amber-kallor/2015/january/126/590/885/chanel-headphones-lexi-boling.jpg";
        products = new ArrayList<String>();
        products.add("Product_1_Id");
        products.add("Product_2_Id");

        price = new Price();
        price.setAcquired(new BigDecimal(100));
        price.setPublished(new BigDecimal(150));

        viewCount = 500;
        likesCount = 145;

        comments = new ArrayList<Comment>();
        Comment comment = new Comment();
        comments.add(comment);
        comments.add(comment);

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
