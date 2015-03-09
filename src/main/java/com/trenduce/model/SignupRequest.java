package com.trenduce.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotEmpty;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

import javax.validation.constraints.Size;

/**
 * Created by prafulmantale on 1/2/15.
 */
public class SignupRequest {

    @NotBlank @NotNull
    @JsonProperty("fn")
    private String firstName;

    @NotBlank @NotNull
    @JsonProperty("ln")
    private String lastName;

    @NotNull @NotBlank @Email
    @JsonProperty("email")
    private String emailID;

    @NotNull @NotBlank
    @JsonProperty("pwd")
    @Size(min = 6, max = 12)
    private String password;

    public SignupRequest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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


}
