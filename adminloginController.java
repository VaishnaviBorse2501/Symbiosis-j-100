package com.example.artistmarketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.artistmarketplace.entity.User;
import com.example.artistmarketplace.entity.adminloginEntity;
import com.example.artistmarketplace.repository.signupRepository;
import com.example.artistmarketplace.service.adminloginService;
import com.example.artistmarketplace.service.signupService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class adminloginController {
			
		 @Autowired
		    private adminloginService adminloginservice;
		 
		 @Autowired
		    private signupService signupservice;
		 
		 
		
		  @PostMapping("/adminlogin")
		    public ResponseEntity<adminloginEntity> login(@RequestBody adminloginEntity adminloginentity ) {
		    	adminloginEntity admin = adminloginservice.login(adminloginentity .getEmail(), adminloginentity .getPassword());
		        if (admin != null) {
		            return ResponseEntity.ok(admin); // Return user details on successful login
		        }
		        return ResponseEntity.status(401).body(null); // Unauthorized
		    }
		    @Autowired
		    signupRepository repo;
		   @GetMapping("/users")
		    public ResponseEntity<List<User>> getAllUsers() {
		       // List<User> users = signupservice.getAllUsers();
			   List<User> myusers=repo.findAll();
		        return ResponseEntity.ok(myusers);
		    }
		    

	}
