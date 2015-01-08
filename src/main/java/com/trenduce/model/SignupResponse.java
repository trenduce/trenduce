package com.trenduce.model;

import com.trenduce.BaseResponse;
import com.trenduce.Status;

//import javax.servlet.http.HttpServletResponse;

/**
 * Created by prafulmantale on 1/2/15.
 */
public class SignupResponse extends BaseResponse {

    public SignupResponse(Status status) {
        super(status);
    }

    public SignupResponse(Status status, String errorCode) {
        super(status, errorCode);
    }

//    public SignupResponse(Status status, HttpServletResponse response) {
//        super(status, response);
//    }
}
