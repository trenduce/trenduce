package com.trenduce;

/**
 * Created by prafulmantale on 1/2/15.
 */
public class ResponseTuple {

    private String key;
    private String value;

    public ResponseTuple() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ResponseTuple{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
