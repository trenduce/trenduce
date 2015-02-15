package com.trenduce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by prafulmantale on 1/5/15.
 */

@Document(collection = "conversations")
public class Conversation {

    @Id
    private String id;

    private String fromUser;
    private String toUser;

    private String subject;

    private long timestamp;

    private String text;

    public Conversation() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    private class Message{

        private String text;
        private long timestamp;
        private String fromUser;
        private String toUser;

        public Message(String fromUser, String toUser, String text) {
            this.text = text;
            timestamp = System.currentTimeMillis();
        }

        public String getText() {
            return text;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
