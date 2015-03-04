package com.trenduce.model;

import com.trenduce.BaseResponse;
import com.trenduce.Status;

//import javax.servlet.http.HttpServletResponse;

/**
 * Created by prafulmantale on 1/2/15.
 */
public class SignupResponse extends BaseResponse {

    private String userId;

    public SignupResponse(Status status) {
        super(status);
    }

    public SignupResponse(Status status, String errorCode) {
        super(status, errorCode);
    }

//    public SignupResponse(Status status, HttpServletResponse response) {
//        super(status, response);
//    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
