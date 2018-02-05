package com.comcast.demo.service.impl;

import com.comcast.demo.exception.ApiException;
import com.comcast.demo.response.bean.FibonacciResponse;
import com.comcast.demo.service.FibonacciService;
import com.comcast.demo.util.ComcastCustomerServicesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciServiceImpl.class);

    @Override
    public ResponseEntity<?> getFibonacciSequence(long number) {

        LOGGER.info("FibonacciSequence request for number {}", number);

        FibonacciResponse response = new FibonacciResponse();

        StringBuilder fibonacci= new StringBuilder();

        try{
            if(number>0){
                fibonacci.append("0");
                for(int i=1;i<number;i++)
                {
                    fibonacci.append(",");
                    fibonacci.append(fibonacciRecursive(i));
                }

                response.setMessage("FibonocciSequenece for N"+":"+number);
                response.setFibonnaciSequence(fibonacci.toString());

                return new ResponseEntity<FibonacciResponse>(response, HttpStatus.OK);
            }else
            {
               return new ResponseEntity<ApiException>(ComcastCustomerServicesUtil.generateInvalidRequestError("number"), HttpStatus.BAD_REQUEST);
            }


        } catch (Exception generateEx) {
        LOGGER.error("generate fibnocci sequence failed {}", generateEx.getMessage());
        return new ResponseEntity<ApiException>(ComcastCustomerServicesUtil.generateInternalServerError(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }

    private int fibonacciRecursive(long number) {
        {
            if(number==0)
                return 0;
            if(number==1)
                return 1;
            else
                return fibonacciRecursive(number-1)+fibonacciRecursive(number-2);
        }
    }


}
