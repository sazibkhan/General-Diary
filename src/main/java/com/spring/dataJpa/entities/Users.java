package com.spring.dataJpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "username",unique=true)
	private String username;
	
	@Column(name = "nickName")
	private String nickName;	
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name="thanaName")
	private String thanaName;
	
	@Column(name="ocIdentificationId")
	private String ocIdentificationId;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getThanaName() {
		return thanaName;
	}

	public void setThanaName(String thanaName) {
		this.thanaName = thanaName;
	}

	public String getOcIdentificationId() {
		return ocIdentificationId;
	}

	public void setOcIdentificationId(String ocIdentificationId) {
		this.ocIdentificationId = ocIdentificationId;
	}

}
