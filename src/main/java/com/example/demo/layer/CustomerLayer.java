package com.example.demo.layer;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.customer;
public interface CustomerLayer extends JpaRepository <customer, String> {
	List<customer> findByEmailOrMobile(String email, long mobile);
	;
	
}
