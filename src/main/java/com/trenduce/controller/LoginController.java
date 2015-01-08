package com.trenduce.controller;

import com.trenduce.Status;
import com.trenduce.helper.Constants;
import com.trenduce.model.LoginRequest;
import com.trenduce.model.LoginResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by prafulmantale on 1/2/15.
 */
@Controller
public class LoginController {

    @RequestMapping(value = Constants.URL_LOGIN, method = RequestMethod.GET)
    public String login(){

        return Constants.JSP_LOGIN;
    }

    @RequestMapping(value = Constants.URL_LOGIN, method = RequestMethod.POST)
    public @ResponseBody
    LoginResponse login(@RequestBody LoginRequest loginRequest, Errors results){

        LoginResponse loginResponse = null;

        if(loginRequest == null ||
                loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty() ||
                loginRequest.getUserName() == null || loginRequest.getUserName().isEmpty()){
            loginResponse = new LoginResponse(Status.FAILURE);
            return loginResponse;
        }

        loginResponse = new LoginResponse(Status.SUCCESS);
        return loginResponse;
    }
}
