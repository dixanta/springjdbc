/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.core.builder;

import com.lfa.core.entity.Course;
import com.lfa.core.entity.Enquiry;
import com.lfa.core.entity.EnquiryStatus;

/**
 *
 * @author USER
 */
public class EnquiryBuilder {

    private int id;
    private String firstName, lastName, email, contactNo,message;
    private Course course;
    private EnquiryStatus status;
    
    private EnquiryBuilder(){
        
    }
    
    public static EnquiryBuilder create(){
        return new EnquiryBuilder();
    }

    public EnquiryBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public EnquiryBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EnquiryBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EnquiryBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public EnquiryBuilder setContactNo(String contactNo) {
        this.contactNo = contactNo;
        return this;
    }
    
    public EnquiryBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public EnquiryBuilder setCourse(Course course) {
        this.course = course;
        return this;
    }

    public EnquiryBuilder setStatus(EnquiryStatus status) {
        this.status = status;
        return this;
    }
    
    public Enquiry build(){
        return new Enquiry(id, firstName, lastName, email, contactNo, course, status);
    }

}
