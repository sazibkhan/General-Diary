package com.spring.dataJpa.dtos;

import java.io.Serializable;

public class RegDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	 private Long reagistationID;
	 private String userName;
	 private String password;
	 private String conformPassword;
	 private String email;
	
	 
	 
	public Long getReagistationID() {
		return reagistationID;
	}
	public void setReagistationID(Long reagistationID) {
		this.reagistationID = reagistationID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConformPassword() {
		return conformPassword;
	}
	public void setConformPassword(String conformPassword) {
		this.conformPassword = conformPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	 
}
