package com.comcast.demo.api;



import com.comcast.demo.exception.ApiException;
import com.comcast.demo.request.bean.CustomerDetailsRequest;

import com.comcast.demo.response.bean.CustomersResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




public interface UpdateApi {

    @ApiOperation(value = "Update  customers Details for given Request.",
            notes = "This API will customer Details",
            response = CustomersResponse.class, tags={ "CustomerDetailsUpdate", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Updates the customer details", response = CustomersResponse.class),
            @ApiResponse(code = 400, message = "BAD Request", response = ApiException.class),
            @ApiResponse(code = 404, message = "Service Not found", response = Void.class),
            @ApiResponse(code = 500, message = "Internal Service ApiError", response = ApiException.class),
            @ApiResponse(code = 500, message = "Backend Service error", response = ApiException.class) })
    @RequestMapping(value = "/customers/custId", method = RequestMethod.PUT)
    public ResponseEntity<?>updateCustomerDetails(@ApiParam(value = "application-id", required = true)
                                                      @RequestHeader(value = "application-id", required = true) String applicationId,
                                                      @RequestBody CustomerDetailsRequest customer);


}
