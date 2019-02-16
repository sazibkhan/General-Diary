package com.spring.dataJpa.dtos;

import java.io.Serializable;


public class UsersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;	
	private String nickName;		
	private String password;	
	private boolean enabled;
	private String mobileNo;	
	private String roleName;
	private String thanaName;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
