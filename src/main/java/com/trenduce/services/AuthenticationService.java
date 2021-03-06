package com.trenduce.services;

import com.trenduce.Status;
import com.trenduce.helper.ErrorCodes;
import com.trenduce.model.LoginRequest;
import com.trenduce.model.LoginResponse;
import com.trenduce.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by prafulmantale on 2/14/15.
 */

@Service
public class AuthenticationService {


    @Autowired
    private UserService userService;



    public LoginResponse login(LoginRequest loginRequest){

        LoginResponse response = new LoginResponse(Status.FAILURE);


        if(loginRequest == null ||
                loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty() ||
                loginRequest.getEmailId() == null || loginRequest.getEmailId().isEmpty()){
            response = new LoginResponse(Status.FAILURE);
            response.setErrorCode(ErrorCodes.REQUEST_WITH_INSUFFICIENT_OR_ICORRECT_DATA_CODE);
            response.setErrorMessage(ErrorCodes.REQUEST_WITH_INSUFFICIENT_OR_ICORRECT_DATA_MESSAGE);
            return response;
        }

        UserProfile userProfile = userService.findUserByEmailId(loginRequest.getEmailId());

        if(userProfile == null){
            response.setErrorCode(ErrorCodes.USER_DOESNOT_EXIST_CODE);
            response.setErrorMessage(ErrorCodes.USER_DOESNOT_EXIST_MESSAGE);

            return response;
        }

        if(userProfile.getPassword().equals(loginRequest.getPassword())){
            response.setStatus(Status.SUCCESS);
            response.setUserId(userProfile.getId());
        }
        else{
            response.setErrorCode(ErrorCodes.INCORRECT_CREDENTIALS_CODE);
            response.setErrorMessage(ErrorCodes.INCORRECT_CREDENTIALS_MESSAGE);
        }

        return response;
    }
}
