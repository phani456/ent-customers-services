package com.comcast.demo.response.bean;

import com.comcast.demo.bean.Post;

import java.util.ArrayList;

public class PostsResponse {

    private ArrayList<Post> customersPosts;

    public ArrayList<Post> getCustomersPosts() {
        return customersPosts;
    }

    public void setCustomersPosts(ArrayList<Post> customersPosts) {
        this.customersPosts = customersPosts;
    }
}
