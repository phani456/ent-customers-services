

package com.comcast.demo.model;

 import javax.persistence.Id;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private long userID;

    @NotNull
    private String email;

    @NotNull
    private String firstname;


    @NotNull
    private String lastname;


    public Customer() { }

    public Customer(long userID) {
        this.userID = userID;
    }

    public Customer(String email, String firstName,String lastName) {
        this.email = email;
        this.firstname = firstName;
        this.lastname=lastName;
    }


    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }
}

