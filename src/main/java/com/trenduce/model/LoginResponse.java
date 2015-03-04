package com.trenduce.model;

import com.trenduce.BaseResponse;
import com.trenduce.Status;

//import javax.servlet.http.HttpServletResponse;

/**
 * Created by prafulmantale on 1/2/15.
 */
public class LoginResponse  extends BaseResponse{

    private String userId;

    public LoginResponse(Status status) {
        super(status);
    }

    public LoginResponse(Status status, String errorCode) {
        super(status, errorCode);
    }

//    public LoginResponse(Status status, HttpServletResponse response) {
//        super(status, response);
//    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
