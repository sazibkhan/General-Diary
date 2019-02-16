package com.spring.dataJpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="gdTabale")
public class GdEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "gdID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gdID;
	
	@Column(name="gdSubject")
	 private String gdSubject;

	@Column(name="nidNumber")
	private int nidNumber;
	
	@Column(name="userName")
	 private String userName;
	
	@Column(name="fatherName")
	 private String fatherName;
	
	@Column(name="motherName")
	 private String motherName;

	@Column(name="email")
	private String email;
	 
	
	@Column(name="phone")
	 private int phone;
	
	@Column(name="gender")
	private String gender;	
	
	
	@ManyToOne
	@JoinColumn(name="countryID")
	private CountryEntity countryEntity;
	
	@ManyToOne
	@JoinColumn(name="divisionID")
	private DivisionEntity divisionEntity;
	
	@ManyToOne
	@JoinColumn(name="districtID")
	private DistrictEntity districtEntity;
	
	
	@ManyToOne
	@JoinColumn(name="thanaId")
	private ThanaEntity thanaEntity;

	
	
	
	
	@Column(name="productDescription")
	private String productDescription;
	
	@Column(name="locationDescription")
	private String locationDescription;
	
	@Column(name="seenStatus")
	private boolean seenStatus;
	
	
	public Long getGdID() {
		return gdID;
	}

	public void setGdID(Long gdID) {
		this.gdID = gdID;
	}

	public String getGdSubject() {
		return gdSubject;
	}

	public void setGdSubject(String gdSubject) {
		this.gdSubject = gdSubject;
	}

	public int getNidNumber() {
		return nidNumber;
	}

	public void setNidNumber(int nidNumber) {
		this.nidNumber = nidNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public CountryEntity getCountryEntity() {
		
		return countryEntity;
	}

	public void setCountryEntity(CountryEntity countryEntity) {
		this.countryEntity = countryEntity;
	}

	public DivisionEntity getDivisionEntity() {
		return divisionEntity;
	}

	public void setDivisionEntity(DivisionEntity divisionEntity) {
		this.divisionEntity = divisionEntity;
	}

	public DistrictEntity getDistrictEntity() {
		return districtEntity;
	}

	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ThanaEntity getThanaEntity() {
		return thanaEntity;
	}

	public void setThanaEntity(ThanaEntity thanaEntity) {
		this.thanaEntity = thanaEntity;
	}

	
	
	

	
	
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	
	public boolean isSeenStatus() {
		return seenStatus;
	}

	public void setSeenStatus(boolean seenStatus) {
		this.seenStatus = seenStatus;
	}
	
}















