package com.comcast.demo.response.bean;

import com.comcast.demo.bean.CustomerDetails;

import java.util.List;

public class CustomersResponse {

    List<CustomerDetails> customers;

    public List<CustomerDetails> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDetails> customers) {
        this.customers = customers;
    }
}
