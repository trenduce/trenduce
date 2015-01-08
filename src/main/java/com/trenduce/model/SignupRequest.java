package com.trenduce.model;


import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotEmpty;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

/**
 * Created by prafulmantale on 1/2/15.
 */
public class SignupRequest {

    @NotNull @NotBlank
    private String userName;

    @NotNull @NotBlank @Email
    private String emailID;

    @NotNull @NotBlank
    private String password;

    public SignupRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SignupRequest{" +
                "userName='" + userName + '\'' +
                ", emaiID='" + emailID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
