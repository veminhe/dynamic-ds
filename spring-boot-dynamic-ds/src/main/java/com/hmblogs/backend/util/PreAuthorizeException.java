package com.hmblogs.backend.util;

public class PreAuthorizeException extends RuntimeException{
    private String errMsg;

    public PreAuthorizeException(String message, Throwable cause) {
        super(message, cause);
        this.errMsg = message;
    }

    public PreAuthorizeException(String message) {
        super(message);
        this.errMsg = message;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
