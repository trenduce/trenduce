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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (!name.equals(category.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
