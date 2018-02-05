package com.comcast.demo.service;

import org.springframework.http.ResponseEntity;

public interface  FibonacciService {

    public ResponseEntity<?> getFibonacciSequence(long number);

}

