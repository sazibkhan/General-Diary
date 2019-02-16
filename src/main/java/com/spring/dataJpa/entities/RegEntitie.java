package com.spring.dataJpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="regtable")
public class RegEntitie implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "reagistationID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reagistationID;
	
	@Column(name = "userName")
    private String userName;
	
	
	
	@Column(name="password")
	private String password;
	
	
	@Column(name = "email")
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
}
