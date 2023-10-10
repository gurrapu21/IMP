package com.example.inventory.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data

public class Login {
	@Id
	String userId;
	String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	public Login() {
		super();
	}
	
	
	
	

}
