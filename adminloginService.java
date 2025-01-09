package com.example.artistmarketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.artistmarketplace.entity.adminloginEntity;
import com.example.artistmarketplace.repository.adminloginRepository;

@Service
public class adminloginService {

		@Autowired
	    private adminloginRepository adminloginrepository;
		
		public adminloginEntity login(String email, String password) {
			adminloginEntity admin = adminloginrepository.findByEmail(email);
	        if (admin != null && admin.getPassword().equals(password)) { // In production, use hashed password comparison
	            return admin;
	        }
	        return null; // Return null if login fails
	    }
		
	
		
	}
	
	
	


