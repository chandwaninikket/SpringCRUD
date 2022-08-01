package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name="customer")

public class customer {
	
	@NotNull
	@Size(min=2,message="First name should be 2 characters long")
	private String first_name;
	
	@NotNull
	@Size(min=2,message="First name should be 2 characters long")
	private String last_name;
	
	@Email
	@NotBlank
	private String email;
	
	@Email
	@NotBlank
	private String email_alt;
	
	@NotNull
	@Digits(integer=10, fraction=0, message="Mobile number should be 10 digits")
	private long mobile;
	
	@NotNull
//	@Digits(fraction = 0, integer = 10)
	private long mobile_alt;
	
	@NotNull
	private String city;
	
	@NotNull
	private String address;
	
	@NotNull
	private String address_alt;
	
	@NotNull
	@Size(min=2, message="Enter proper name of the state")
	private String state;
	
	@NotNull
	@Size(min=2,message="Enter entire name of the country")
//	@Default(India)
	private String country;
	
	@NotNull
	private long pincode;
	
	@Column(name="customerID")
	private String customerid;
	
	@Column(name="status")
	private String status;
	
	@Column(name="first_name", nullable=false)
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	@Column(name="last_name", nullable=false)
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	@Column(name="email", nullable=false,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="email_alt", nullable=false)
	public String getEmail_alt() {
		return email_alt;
	}
	public void setEmail_alt(String email_alt) {
		this.email_alt = email_alt;
	}
	
	@Column(name="mobile",nullable=false,unique=true)
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	@Column(name="mobile_alt", nullable=false)
	public long getMobile_alt() {
		return mobile_alt;
	}
	public void setMobile_alt(long mobile_alt) {
		this.mobile_alt = mobile_alt;
	}
	
	@Column(name="city", nullable=false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="address",nullable=false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="address_alt",nullable=false)
	public String getAddress_alt() {
		return address_alt;
	}
	public void setAddress_alt(String address_alt) {
		this.address_alt = address_alt;
	}
	
	@Column(name="state",nullable=false)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name="country",nullable=false)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name="pincode",nullable=false)
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	
	@Id
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "customer [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", email_alt="
				+ email_alt + ", mobile=" + mobile + ", mobile_alt=" + mobile_alt + ", city=" + city + ", address="
				+ address + ", address_alt=" + address_alt + ", state=" + state + ", country=" + country + ", pincode="
				+ pincode + ", customerid=" + customerid + ", status=" + status + "]";
	}
	
	//default constructor
	public customer() {
		super();
	}
	
	//main constructor
	public customer(String first_name, String last_name, String email, String email_alt, long mobile,
			long mobile_alt, String city, String address, String address_alt, String state, String country,
			long pincode) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.email_alt = email_alt;
		this.mobile = mobile;
		this.mobile_alt = mobile_alt;
		this.city = city;
		this.address = address;
		this.address_alt = address_alt;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
//	public customer(String test) {
//		if (test=="delete") {
//			
//		}
//	}
	
	
	
}
