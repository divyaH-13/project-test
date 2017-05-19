package com.hotelbookingapplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbookingapplication.model.Customer;
import com.hotelbookingapplication.repository.CustomerRepo;




@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
 private CustomerRepo cr;
	
	@RequestMapping(method=RequestMethod.GET, value="/allcustomers")
	@ResponseBody
	public List<Customer> findall(){
		return cr.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customer/{id}")
	@ResponseBody
	public Customer getone(@PathVariable Integer id){
		return cr.findOne(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/addcustomer")
	@ResponseBody
	public void addTopic(@RequestBody Customer customer){
		cr.save(customer);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/customer/{id}")
	@ResponseBody
	public void updateTopic(@RequestBody Customer customer,@PathVariable Integer id){
		Customer customerToUpdate = cr.findOne(id);
        if(customerToUpdate != null){
        	customerToUpdate.setId(customer.getId());
        	customerToUpdate.setFirstname(customer.getFirstname());
        	customerToUpdate.setLastname(customer.getLastname());
        	customerToUpdate.setAge(customer.getAge());        
           cr.save(customer);
        }
		
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/customer/{id}")
	@ResponseBody
	public void deleteTopic(@PathVariable Integer id){
		cr.delete(id);
	}
	
}
