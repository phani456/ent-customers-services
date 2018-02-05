package com.comcast.demo.util;

import com.comcast.demo.exception.ApiException;

public class ComcastCustomerServicesUtil {


    public static final String INVALID_REQ_ERR_CD ="CUSTOMER_MANAGEMENT_CODE_001";
    public static final String CUSTOMER_NOT_FOUND_ERR_CD = "CUSTOMER_MANAGEMENT_CODE_002";
    public static final String BACKEND_FAILURE_ERR_CD ="CUSTOMER_MANAGEMENT_CODE_003";
    public static final String CUSTOMER_LOOKUP_FAILURE_ERR_CD = "CUSTOMER_MANAGEMENT_CODE_004";
    public static final String CUSTOMER_UPDATE_FAILURE_ERR_CD = "CUSTOMER_MANAGEMENT_CODE_005";
    public static final String CUSTOMER_MANAGEMENT_001="Invalid Request-Missing required input params";
    public static final String CUSTOMER_MANAGEMENT_002="Customer not found";
    public static final String CUSTOMER_MANAGEMENT_004="Customer Lookup Failed  - Internal Server Error";
    public static final String CUSTOMER_MANAGEMENT_005="Customer update Failed  - Internal Server Error";

    public static final String SUCCESS_RESPONSE= "Success";

    public static ApiException generateCustomerNotFoundError(){

        ApiException customerNotFoundError = new ApiException();
        customerNotFoundError.setCode(CUSTOMER_NOT_FOUND_ERR_CD);
        customerNotFoundError.setUserMessage(CUSTOMER_MANAGEMENT_002);
        return  customerNotFoundError;
    }
    public static ApiException generateInvalidRequestError(String missingInput){

        ApiException invalidRequestError = new ApiException();
        invalidRequestError.setCode(INVALID_REQ_ERR_CD);
        invalidRequestError.setUserMessage(CUSTOMER_MANAGEMENT_001+ ":"+missingInput);;
        return  invalidRequestError;
    }
    public static ApiException generateCustomerLookupError(){

        ApiException customerLookupError= new ApiException();
        customerLookupError.setCode(CUSTOMER_LOOKUP_FAILURE_ERR_CD);
        customerLookupError.setUserMessage(CUSTOMER_MANAGEMENT_004);
        return  customerLookupError;
    }
    public static ApiException generateCustomerUpdateError(){

        ApiException customerUpdateError= new ApiException();
        customerUpdateError.setCode(CUSTOMER_UPDATE_FAILURE_ERR_CD);
        customerUpdateError.setUserMessage(CUSTOMER_MANAGEMENT_005);
        return  customerUpdateError;
    }
    public static ApiException generateBackendServiceError(){

        ApiException backEndServiceError= new ApiException();
        backEndServiceError.setCode(BACKEND_FAILURE_ERR_CD);
        backEndServiceError.setUserMessage(CUSTOMER_MANAGEMENT_005);
        return  backEndServiceError;
    }
    public static ApiException generateInternalServerError(){

        ApiException backEndServiceError= new ApiException();
        backEndServiceError.setCode(BACKEND_FAILURE_ERR_CD);
        backEndServiceError.setUserMessage(CUSTOMER_MANAGEMENT_004);
        return  backEndServiceError;
    }

}
