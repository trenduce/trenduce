package com.trenduce.controller;

import com.trenduce.Status;
import com.trenduce.helper.Constants;
import com.trenduce.helper.ErrorCodes;
import com.trenduce.model.SignupRequest;
import com.trenduce.model.SignupResponse;
import com.trenduce.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by prafulmantale on 1/2/15.
 */
@Controller
public class SignupController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = Constants.URL_SIGN_UP, method = RequestMethod.GET)
    public String signup(){
        return Constants.JSP_SIGNUP;
    }

    @RequestMapping(value = Constants.URL_SIGN_UP, method = RequestMethod.POST,
            consumes = Constants.CONTENT_JSON, produces = Constants.CONTENT_JSON)
    @ResponseBody SignupResponse signup(@Valid @RequestBody SignupRequest signupRequest, Errors result){

        SignupResponse response = null;

        if(result.hasErrors()){
            response = new SignupResponse(Status.FAILURE);
            response.setErrorCode(ErrorCodes.REQUEST_WITH_INSUFFICIENT_OR_ICORRECT_DATA);
            return response;
        }

        response = registrationService.register(signupRequest);

        return response;
    }
}
