package com.ll.studentControl.handler;

public class CustomGenericException extends RuntimeException {

    private String errMsg;
    private Exception exception;

    public CustomGenericException(String errMsg, Exception e) {
        super(errMsg, e);
        this.errMsg = errMsg;
        this.exception = e;
    }
}
