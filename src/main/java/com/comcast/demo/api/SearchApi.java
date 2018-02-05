package com.comcast.demo.api;



import com.comcast.demo.exception.ApiException;
import com.comcast.demo.response.bean.CustomerGreetingResponse;
import com.comcast.demo.response.bean.CustomersResponse;
import com.comcast.demo.response.bean.FibonacciResponse;
import com.comcast.demo.response.bean.PostsResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-03T00:38:48.928Z")

@Api(value = "search", description = "the search API")
public interface SearchApi {

    @ApiOperation(value = "GET Customer Greeting Notes.",
                  notes = "This API will return the customer Greeting Details",
                  response = CustomerGreetingResponse.class, tags={ "CustomerGreetingDetails", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the Customer Greeting Details", response = CustomerGreetingResponse.class),
            @ApiResponse(code = 400, message = "BAD Request", response = ApiException.class),
            @ApiResponse(code = 404, message = "Service Not found", response = Void.class),
            @ApiResponse(code = 500, message = "Internal Service ApiError", response = ApiException.class),
            @ApiResponse(code = 500, message = "Backend Service error", response = ApiException.class) })
    @RequestMapping(value = "/customers/greetingDetails", produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerGreetingMessage(@ApiParam(value = "application-id", required = true)
                                                        @RequestHeader(value = "application-id", required = true) String applicationId,
                                                        @ApiParam(value = "name", required = false)
                                                        @RequestParam(value = "name", defaultValue = "World", required = false) final String name);

    @ApiOperation(value = "GET all customers Details.",
            notes = "This API will return the customer  Details",
            response = CustomersResponse.class, tags={ "CustomerDetails", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the Customer Greeting Details", response = CustomersResponse.class),
            @ApiResponse(code = 400, message = "BAD Request", response = ApiException.class),
            @ApiResponse(code = 404, message = "Service Not found", response = Void.class),
            @ApiResponse(code = 500, message = "Internal Service ApiError", response = ApiException.class),
            @ApiResponse(code = 500, message = "Backend Service error", response = ApiException.class) })
    @RequestMapping(value = "/customers/", produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<?> lookupCustomerDetails(@ApiParam(value = "application-id", required = true)
                                                   @RequestHeader(value = "application-id", required = true) String applicationId);


    @ApiOperation(value = "GET fibonacci numbers for given N.",
            notes = "This API will return fibonacci numbers",
            response = FibonacciResponse.class, tags={ "FibonacciNumbers", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns Fibonacci sequence of numbers", response = FibonacciResponse.class),
            @ApiResponse(code = 400, message = "BAD Request", response = ApiException.class),
            @ApiResponse(code = 404, message = "Service Not found", response = Void.class),
            @ApiResponse(code = 500, message = "Internal Service ApiError", response = ApiException.class),
            @ApiResponse(code = 500, message = "Backend Service error", response = ApiException.class) })
    @RequestMapping(value = "/custom/fibonacci", produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<?> getFibonacciSequenceForGivenNumber(@ApiParam(value = "application-id", required = false)
                                                                @RequestHeader(value = "application-id", required = false) String applicationId,
                                                                @ApiParam(value = "number", required = true)
                                                                @RequestParam(value = "number", required = true) final long number);


    @ApiOperation(value = "GET Posts from jsonPlaceHolder.",
            notes = "This API will return posts from jsonPlaceHolder",
            response = PostsResponse.class, tags={ "CustomerJsonPosts", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns posts from JsonPosts", response = PostsResponse.class),
            @ApiResponse(code = 400, message = "BAD Request", response = ApiException.class),
            @ApiResponse(code = 404, message = "Service Not found", response = Void.class),
            @ApiResponse(code = 500, message = "Internal Service ApiError", response = ApiException.class),
            @ApiResponse(code = 500, message = "Backend Service error", response = ApiException.class) })
    @RequestMapping(value = "/customers/posts", produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerPostsFromJsonPlace(@ApiParam(value = "application-id", required = false)
                                                           @RequestHeader(value = "application-id", required = false) String applicationId);
}
