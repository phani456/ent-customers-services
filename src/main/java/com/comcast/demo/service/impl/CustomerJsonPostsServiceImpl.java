package com.comcast.demo.service.impl;

import com.comcast.demo.bean.Post;
import com.comcast.demo.exception.ApiException;
import com.comcast.demo.response.bean.PostsResponse;
import com.comcast.demo.service.CustomerJsonPostsService;
import com.comcast.demo.util.ComcastCustomerServicesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;


@Service
public class CustomerJsonPostsServiceImpl implements CustomerJsonPostsService {


    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerJsonPostsServiceImpl.class);

    @Autowired
    Environment env;

    @Autowired
    private RestTemplateBuilder builder;

    private RestTemplate restTemplate;




    @Override
    public ResponseEntity<?> lookupCustomersPosts() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        //ObjectMapper objMap = getMapper();
        restTemplate=builder.build();
        String uriString="";
        try{
            final HttpEntity<?> request = new HttpEntity<>(headers);
            UriComponentsBuilder uri = UriComponentsBuilder.fromUriString(env.getProperty("customerJsonPosts.resturl"));
            long startTime = System.currentTimeMillis();
            uriString = uri.toUriString();
            LOGGER.info("URL {}",uriString);
            LOGGER.info("Request Headers {}",request.getHeaders());
            ResponseEntity<Post[]> responseEntity=restTemplate.exchange(uriString, HttpMethod.GET, request, Post[].class);
            PostsResponse response = new PostsResponse();
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                ArrayList<Post> customersPosts= new ArrayList();
                Post[]  postArray=responseEntity.getBody();
                LOGGER.info("response status code :" + responseEntity.getStatusCode());

                if(postArray!=null)
                {
                    Stream<Post> postArrayStream = Arrays.stream(postArray);
                    postArrayStream.forEach(postMessage->{
                        Post post = new Post();
                        post.setId(postMessage.getId());
                        post.setBody(postMessage.getBody());
                        post.setTitle(postMessage.getTitle());
                        post.setUserId(postMessage.getUserId());
                        customersPosts.add(post);
                    });
                }
                response.setCustomersPosts(customersPosts);
                return new ResponseEntity<PostsResponse>(response, HttpStatus.OK);
            }

            return null;

        } catch (Exception exeption) {
            LOGGER.error("CustomerJsonPosts API  failed {}", exeption.getMessage());
            return new ResponseEntity<ApiException>(ComcastCustomerServicesUtil.generateInternalServerError(), HttpStatus.INTERNAL_SERVER_ERROR);


        }


    }





}
