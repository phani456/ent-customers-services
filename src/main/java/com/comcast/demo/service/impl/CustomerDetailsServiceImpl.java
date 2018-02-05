
package com.comcast.demo.service.impl;

import com.comcast.demo.exception.ApiException;
import com.comcast.demo.response.bean.CustomersResponse;

import com.comcast.demo.service.CustomerDetailsService;

import com.comcast.demo.util.ComcastCustomerServicesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {




    private static final Logger logger = LoggerFactory.getLogger(CustomerDetailsServiceImpl.class);

    @Override
    public ResponseEntity<?> lookupCustomerDetails() {
        try {

            CustomersResponse response = new CustomersResponse();

          //  response.setCustomers(repository.findAll());

            return new ResponseEntity<CustomersResponse>(response, HttpStatus.OK);

        } catch (Exception exeption) {
            logger.error("CustomerDetailsServiceImpl API  failed {}", exeption.getMessage());
            return new ResponseEntity<ApiException>(ComcastCustomerServicesUtil.generateInternalServerError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
