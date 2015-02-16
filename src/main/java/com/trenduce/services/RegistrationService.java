package com.trenduce.services;

import com.trenduce.Status;
import com.trenduce.helper.ErrorCodes;
import com.trenduce.model.SignupRequest;
import com.trenduce.model.SignupResponse;
import com.trenduce.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by prafulmantale on 2/14/15.
 */
@Service
public class RegistrationService {

    private static final String TAG = RegistrationService.class.getSimpleName();

    @Autowired
    private UserService userService;

    public SignupResponse register(SignupRequest request){

        SignupResponse response = new SignupResponse(Status.FAILURE);

        if(request == null ||
                ((request.getUserName() == null || request.getUserName().isEmpty()) &&
                        (request.getEmailID() == null || request.getEmailID().isEmpty())) ||
                request.getPassword() == null || request.getPassword().isEmpty()){

            response.setErrorCode(ErrorCodes.REQUEST_WITH_INSUFFICIENT_OR_ICORRECT_DATA);
            return  response;
        }

        try{

            UserProfile userProfile = userService.findUserByEmailId(request.getUserName());

            if(userProfile != null){
                userProfile = userService.findUserByEmailId(request.getEmailID());
            }

            if(userProfile != null){
                response.setErrorCode(ErrorCodes.USER_ALREADY_EXISTS);
                return response;
            }
            else{
                userProfile = new UserProfile();
                userProfile.setEmailId(request.getEmailID());
                userProfile.setPassword(request.getPassword());

                userService.addUser(userProfile);

                response.setStatus(Status.SUCCESS);
            }

        }
        catch (Exception ex){

            System.out.println("Exception while regisering user. " + TAG + ".register" + "\r\n" + ex.getMessage());
            response = new SignupResponse(Status.FAILURE);
        }


        return response;
    }
}
