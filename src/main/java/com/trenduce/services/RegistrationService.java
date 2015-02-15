package com.trenduce.services;

import com.trenduce.Status;
import com.trenduce.model.SignupRequest;
import com.trenduce.model.SignupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by prafulmantale on 2/14/15.
 */
@Service
public class RegistrationService {

    @Autowired
    private UserService userService;

    public SignupResponse register(SignupRequest request){

        SignupResponse response = null;

        try{

        }
        catch (Exception ex){
            response = new SignupResponse(Status.FAILURE);

        }



        return response;
    }
}
