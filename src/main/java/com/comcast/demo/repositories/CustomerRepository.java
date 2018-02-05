

package com.comcast.demo.repositories;

import com.comcast.demo.model.Customer;
import org.springframework.stereotype.Repository;


import java.util.List;

public interface CustomerRepository {

     Customer findByUserID(Long userID);



     void delete(Long userID);


List<Customer> findAll();

}


