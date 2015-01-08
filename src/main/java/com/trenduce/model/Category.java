package com.trenduce.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by prafulmantale on 1/5/15.
 */
@Document
public class Category {
    private String name; // Shoes, Pants, Jeans etc

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
