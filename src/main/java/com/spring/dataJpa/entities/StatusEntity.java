package com.spring.dataJpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="statusTable")
public class StatusEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="statusID")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long statusID;
	
	@Column(name="name")
	private String name;
	
	@Column(name="level")
	private String level;
	
	@Column(name="discription")
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
