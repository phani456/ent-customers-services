package com.comcast.demo.response.bean;

public class FibonacciResponse {

    private String message;
    private String  fibonnaciSequence ;

    public String getFibonnaciSequence() {
        return fibonnaciSequence;
    }

    public void setFibonnaciSequence(String fibonnaciSequence) {
        this.fibonnaciSequence = fibonnaciSequence;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
