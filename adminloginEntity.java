package com.example.artistmarketplace.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="admin")
public class adminloginEntity {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		private String email;
		private String password;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "adminloginEntity [id=" + id + ", email=" + email + ", password=" + password + "]";
		}
		
	}
	