package com.trenduce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Created by prafulmantale on 1/5/15.
 */
@Document
public class Price {

    private String currency; //INR, USD etc

    @JsonProperty("price")
    private BigDecimal published; //Current price

    @JsonIgnore
    private BigDecimal acquired;//Price at which we acquire the product

    public BigDecimal getPublished() {
        return published;
    }

    public void setPublished(BigDecimal published) {
        this.published = published;
    }

    public BigDecimal getAcquired() {
        return acquired;
    }

    public void setAcquired(BigDecimal acquired) {
        this.acquired = acquired;
    }

}
