package com.spring.dataJpa.dtos;

import java.io.Serializable;

import com.spring.dataJpa.entities.CountryEntity;
import com.spring.dataJpa.entities.DistrictEntity;
import com.spring.dataJpa.entities.DivisionEntity;
import com.spring.dataJpa.entities.ThanaEntity;



public class GdDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	 private Long gdID;
	
	 private String gdSubject;
	 private int nidNumber;
	 private String userName;
	 private String fatherName;
	 private String motherName;
	 private String email;
	 private String gender;
	 private boolean seenStatus;
	 
	 private int phone;
	 
	 private CountryEntity countryEntity;
	 private DivisionEntity divisionEntity;
	 private DistrictEntity districtEntity;
	 private ThanaEntity thanaEntity;
	
	 
	 
	private String productDescription;
	private String locationDescription;
	

	
	
	
	
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
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public CountryEntity getCountryEntity() {
		if(countryEntity==null) countryEntity=new CountryEntity();
		return countryEntity;
	}
	public void setCountryEntity(CountryEntity countryEntity) {
		this.countryEntity = countryEntity;
	}
	public DivisionEntity getDivisionEntity() {
		if(divisionEntity==null) divisionEntity=new DivisionEntity();
		return divisionEntity;
	}
	public void setDivisionEntity(DivisionEntity divisionEntity) {
		this.divisionEntity = divisionEntity;
	}
	public DistrictEntity getDistrictEntity() {
		if(districtEntity==null) districtEntity=new DistrictEntity();
		return districtEntity;
	}
	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
	}
	public ThanaEntity getThanaEntity() {
		if(thanaEntity==null) thanaEntity=new ThanaEntity();
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
