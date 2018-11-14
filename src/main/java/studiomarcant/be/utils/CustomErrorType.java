package studiomarcant.be.utils;

import org.springframework.http.HttpStatus;

/**
 * Created by Win 10 on 13/11/2018.
 */
public class CustomErrorType {
    private Error error;
    private HttpStatus httpStatus;
    private String errorMessage;

    public CustomErrorType(Error error){
        this.error = error;
    }
    public CustomErrorType (String errorMessage){
        this.errorMessage=errorMessage;
    }
    public CustomErrorType (String errorMessage,HttpStatus httpStatus){
        this.errorMessage=errorMessage;
        this.httpStatus=httpStatus;
    }

    public CustomErrorType(Error error, HttpStatus httpStatus ) {
        this.httpStatus = httpStatus;
        this.error = error;
        errorMessage = getErrorMessage(error);
    }

    public HttpStatus getHttpStatus () {
        return httpStatus;
    }

    public String getErrorMessage () {
        return errorMessage;
    }

    public Error getError() {
        return error;
    }

    public String getErrorMessage(Error error){
        return error.getMessage();
    }
}

