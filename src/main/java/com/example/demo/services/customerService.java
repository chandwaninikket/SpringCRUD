package com.example.demo.services;
import com.example.demo.entities.customer;
import java.util.*;
public interface customerService {

	public customer getCustomer(String customerId);

	public customer addCustomer(customer customer);

	public List<customer> getCustomers();

	public void deleteCustomer(String customerid);
	
	public customer modifyCustomer(customer Customer, String customerid);
	
	public customer findCustomer(Map <String, Object> obj);
}
