package com.trenduce;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by prafulmantale on 1/2/15.
 */
public class BaseResponse {

    protected Status status;
    protected String errorCode;
    protected String errorMessage;

    public BaseResponse(Status status) {
        this.status = status;
    }

    public BaseResponse(Status status, String errorCode)
    {
        this.status = status;
        this.errorCode = errorCode;
    }

//    protected BaseResponse( Status status, HttpServletResponse response )
//    {
//        this.status = status;
//        if ( response != null )
//        {
//            if ( status == Status.FAILURE )
//            {
//                response.setStatus( HttpServletResponse.SC_BAD_REQUEST );
//            }
//            else
//            {
//                response.setStatus( HttpServletResponse.SC_OK );
//            }
//        }
//    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
