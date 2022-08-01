package com.example.demo.services;
import java.util.ArrayList;



import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.*;
import java.math.*;
import com.example.demo.layer.*;
//import org.apache.commons.lang3.RandomStringUtils;

@Service
public class customerServiceImp implements customerService {
	List<customer> list = new ArrayList<>();
	
	@Autowired
	private CustomerLayer CustomerLayer;
		
	public customerServiceImp() {
	
	}
	@Override
	public customer getCustomer(String customerId) {
		
		Optional <customer> optionalEntity = CustomerLayer.findById(customerId);
		return optionalEntity.get();
	}
	@Override
	public customer addCustomer(customer Customer) {
		String customerId = generateCustomerID();
		Customer.setCustomerid(customerId);
		Customer.setStatus("ACTIVE");
		CustomerLayer.save(Customer);
		return Customer;
	}
	
	public customer findCustomer(Map<String, Object> obj) {
		String email = String.valueOf(obj.get("email"));
		long mobile = Long.parseLong(String.valueOf(obj.get("mobile")));
		customer result;
		result = this.CustomerLayer.findByEmailOrMobile(email, mobile).get(0);
		return result;
	}
	
	private String generateCustomerID() {
		StringBuilder ans1 = new StringBuilder();
		int randomBankCode=(int)(Math.random()*(10-1+1)+1);
		int randomTxnCode=(int)(Math.random()*(1000000-1+1)+1);
		String randomCustomerCode= String.format("%09d", randomTxnCode);
//		String randomCode = Integer.toString(randomBankCode)+ 
		ans1.append("CUA1C" + Integer.toString(randomBankCode)+"D0A"+ randomCustomerCode);
		return ans1.toString();
		
	}
	@Override
	public List<customer> getCustomers() {
		return CustomerLayer.findAll();
	}
	@Override
	public void deleteCustomer(String customerid) {
		customer toBeDeleted= getCustomer(customerid);
		toBeDeleted.setStatus("DELETED");
		CustomerLayer.save(toBeDeleted);
		}
	@Override
	public customer modifyCustomer(customer Customer, String id) {
		customer Result; 
		Optional<customer> cust = CustomerLayer.findById(id);
		Result = cust.get();
		Result.setCity(Customer.getCity());
		Result.setState(Customer.getState());
		Result.setEmail_alt(Customer.getEmail_alt());
		Result.setMobile_alt(Customer.getMobile_alt());
		Result.setAddress_alt(Customer.getAddress_alt());
		CustomerLayer.save(Result);
		return Result;
		
	}
}