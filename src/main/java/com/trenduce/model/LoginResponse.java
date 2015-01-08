package com.trenduce.model;

import com.trenduce.BaseResponse;
import com.trenduce.Status;

//import javax.servlet.http.HttpServletResponse;

/**
 * Created by prafulmantale on 1/2/15.
 */
public class LoginResponse  extends BaseResponse{

    public LoginResponse(Status status) {
        super(status);
    }

    public LoginResponse(Status status, String errorCode) {
        super(status, errorCode);
    }

//    public LoginResponse(Status status, HttpServletResponse response) {
//        super(status, response);
//    }
}
