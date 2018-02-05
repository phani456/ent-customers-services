package com.comcast.demo.controller;


import com.comcast.demo.api.SearchApi;
import com.comcast.demo.exception.ApiException;
import com.comcast.demo.response.bean.CustomerGreetingResponse;
import com.comcast.demo.service.CustomerDetailsService;
import com.comcast.demo.service.CustomerJsonPostsService;
import com.comcast.demo.service.FibonacciService;
import com.comcast.demo.util.ComcastCustomerServicesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/customerInfo/v1")
public class ComcastApiController implements SearchApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComcastApiController.class);

    @Autowired
    Environment env;

    @Autowired
    FibonacciService fibService;

    @Autowired
    CustomerJsonPostsService customerPostsService;


   @Autowired
   CustomerDetailsService customerDetailsService;


    @Override
    public ResponseEntity<?> getCustomerGreetingMessage(@RequestHeader String applicationId, @RequestParam String name) {

        if(applicationId!=null){
            LOGGER.info("api=getCustomerGreetingMessage applicationId={} ", applicationId);

            CustomerGreetingResponse customerGreetingResponse = new CustomerGreetingResponse();
            customerGreetingResponse.setId(101);
            customerGreetingResponse.setMessage(String.format(env.getProperty("Customer.GreetingMessage"),name));
            return new ResponseEntity<CustomerGreetingResponse>(customerGreetingResponse, HttpStatus.OK);

        }else{
            return new ResponseEntity<ApiException>(ComcastCustomerServicesUtil.generateInvalidRequestError(applicationId), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> lookupCustomerDetails(String applicationId) {
        if(applicationId!=null){
            LOGGER.info("api=getCustomerGreetingMessage applicationId={} ", applicationId);
           return customerDetailsService.lookupCustomerDetails();
            //return null;
        }else{
            return new ResponseEntity<ApiException>(ComcastCustomerServicesUtil.generateInvalidRequestError(applicationId), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getFibonacciSequenceForGivenNumber(@RequestHeader String applicationId, @RequestParam long number) {

        if(applicationId!=null){
            LOGGER.info("api=getCustomerGreetingMessage applicationId={} ", applicationId);
            return fibService.getFibonacciSequence(number);
        }else{
            return new ResponseEntity<ApiException>(ComcastCustomerServicesUtil.generateInvalidRequestError(applicationId), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> getCustomerPostsFromJsonPlace(@RequestHeader String applicationId) {
        if(applicationId!=null){
            LOGGER.info("api=getCustomerGreetingMessage applicationId={} ", applicationId);
            return customerPostsService.lookupCustomersPosts() ;
        }else{
            return new ResponseEntity<ApiException>(ComcastCustomerServicesUtil.generateInvalidRequestError(applicationId), HttpStatus.BAD_REQUEST);
        }

    }
}
