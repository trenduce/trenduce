package com.trenduce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotEmpty;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

/**
 * Created by prafulmantale on 1/2/15.
 */
public class LoginRequest {

    @NotNull @NotEmpty @Email
    @JsonProperty("email")
    private String emailId;

    @NotNull @NotEmpty
    @JsonProperty("pwd")
    private String password;

    public LoginRequest() {
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
