package com.spring.dataJpa.dtos;

import java.io.Serializable;

public class StatusDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Long statusID;
	private String name;
	private String level;
	private String discription;
	
	
	public Long getStatusID() {
		return statusID;
	}
	public void setStatusID(Long statusID) {
		this.statusID = statusID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
		
}
