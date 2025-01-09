package com.example.artistmarketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.artistmarketplace.entity.adminloginEntity;

public interface adminloginRepository extends JpaRepository<adminloginEntity, Integer> {
	
	adminloginEntity findByEmail(String email);
	
}

