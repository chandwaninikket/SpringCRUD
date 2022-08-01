package com.example.demo.myController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.customer;
import com.example.demo.responseHandler.responseHandle;
import com.example.demo.services.customerService;

import java.util.*;

@RestController

public class myController {
	@Autowired
	private customerService customerService;
	
	
//	//home page
//	@GetMapping("/home")
//	public String home() {
//		return "Home page";
//		
//	}
	
	//getAllCustomers --extra
	@GetMapping("/customers")
	public List<customer> getCustomers(){
		return this.customerService.getCustomers();
	}
	
	//getSingleCustomerUsingID --add response entity
	@GetMapping("/customer/{id}")
	public ResponseEntity<Object> getCustomer(@PathVariable String id){
		try {
			customer Result = this.customerService.getCustomer(id); 
			return responseHandle.generateResponse("Successfully retrieved data", HttpStatus.OK, Result);
		}
		catch(Exception e) {
			return responseHandle.generateResponse("Error in retrieval", HttpStatus.BAD_REQUEST, null);
		}
		 
	}

	//Fix editing
	@PutMapping("/customer/{id}")
	public ResponseEntity<Object> modifyCustomer(@PathVariable String id,@RequestBody customer Customer) {
		try {
			customer Result = this.customerService.modifyCustomer(Customer, id);
			return responseHandle.generateResponse("Updated Successfully", HttpStatus.OK, Result);
		}
		catch (Exception e) {
			return responseHandle.generateResponse("Unsuccessful"+ e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		
	}
	//Add a customer - add response entity
	@PostMapping("/customer")
	public ResponseEntity<Object> addCustomer(@RequestBody customer Customer) {
		try {
			customer Result = this.customerService.addCustomer(Customer);
			return responseHandle.generateResponse("Successfully added data", HttpStatus.OK, Result);
		}
		catch (Exception e){
				return responseHandle.generateResponse("Unsuccessful" + e.getMessage(), HttpStatus.BAD_REQUEST, null); 
		}
	}
	//Get Customer using email
	
	@PostMapping("/customer/personal")
	public ResponseEntity<Object> provideOTP(@RequestBody customer Customer){
		Map <String, String> json = new HashMap<>();
		json.put("authentication_type","otp");
		json.put("authentication_status", "pending");
		return responseHandle.generateResponse("OTP Validation required, please enter OTP From mobile", HttpStatus.OK, json);
	}
	@PostMapping("/customer/validate")
	public ResponseEntity<Object> getCustomerEmail(@RequestBody Map<String, Object> obj){
		try {
			int objOTP = (int) obj.get("otp");
			if (objOTP==123456) {
			customer result = this.customerService.findCustomer(obj);
			//String.valueOf(obj.get("email")), Long.parseLong(String.valueOf(obj.get("mobile"
			return responseHandle.generateResponse("Successful", HttpStatus.OK, result);
		}
			else {
				return responseHandle.generateResponse("Unsuccessful", HttpStatus.INTERNAL_SERVER_ERROR, null);
			}
		}
		catch (Exception e) {
			return responseHandle.generateResponse("Unsuccessful" + e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	}
	//Delete a customer --add response entity
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable String id) {
		try {
			Map<String, String> obj = new HashMap<>();
			this.customerService.deleteCustomer(id);
			obj.put("customer_id",id);
			obj.put("status", "DELETED");
			return responseHandle.generateResponse("Successfully deleted data", HttpStatus.OK, obj);
		}
		catch (Exception e)
		{
			return responseHandle.generateResponse("Unsuccessful" + e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		
	}
	
}
 