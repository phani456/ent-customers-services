package com.comcast.demo.service;

import org.springframework.http.ResponseEntity;

public interface CustomerJsonPostsService {

    public ResponseEntity<?> lookupCustomersPosts();
}
