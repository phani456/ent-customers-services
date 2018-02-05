package com.comcast.demo.exception;

public class ApiException {
    private String code;

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    private String userMessage;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
