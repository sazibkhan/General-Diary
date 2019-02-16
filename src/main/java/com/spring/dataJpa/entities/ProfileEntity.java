package com.spring.dataJpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userProfile")
public class ProfileEntity implements Serializable{
	private static final long serialVersionUID = 1L;

		@Id
		@Column(name="profileID")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long profileID;
	
		@Column(name="photoPath")
		private String photoPath;
		
		@Column(name="profileName")
		private String profileName;
		
		@Column(name="phone")
		private int phone;
		
		@Column(name="email")
		private String email;
		
		@Column(name="religious")
		 private String religious ;
		
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
