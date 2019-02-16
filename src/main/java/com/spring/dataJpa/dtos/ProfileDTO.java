package com.spring.dataJpa.dtos;

import java.io.Serializable;

public class ProfileDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long profileID;	
	private String photoPath;
	private String profileName;
	private int phone;
	private String email;
	 private String religious;
	
	
			
			
			public Long getProfileID() {
				return profileID;
			}
			public void setProfileID(Long profileID) {
				this.profileID = profileID;
			}
			public String getPhotoPath() {
				return photoPath;
			}
			public void setPhotoPath(String photoPath) {
				this.photoPath = photoPath;
			}
			public String getProfileName() {
				return profileName;
			}
			public void setProfileName(String profileName) {
				this.profileName = profileName;
			}
			public int getPhone() {
				return phone;
			}
			public void setPhone(int phone) {
				this.phone = phone;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getReligious() {
				return religious;
			}
			public void setReligious(String religious) {
				this.religious = religious;
			}
			
			
			
			
}
