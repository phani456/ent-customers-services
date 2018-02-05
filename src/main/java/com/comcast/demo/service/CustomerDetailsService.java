package com.comcast.demo.service;

import org.springframework.http.ResponseEntity;

public interface CustomerDetailsService {
    public ResponseEntity<?> lookupCustomerDetails();
}
