package com.hotelbookingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbookingapplication.model.Customer;



public interface CustomerRepo extends JpaRepository<Customer,Integer>{

}
