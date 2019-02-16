package com.spring.dataJpa.dtos;

import java.io.Serializable;

import com.spring.dataJpa.entities.CountryEntity;

public class DivisionDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long divisionID;	
	private String division;
	
	private CountryEntity country;
	
	
	
	public Long getDivisionID() {
		return divisionID;
	}
	public void setDivisionID(Long divisionID) {
		this.divisionID = divisionID;
	}
	
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	
	public CountryEntity getCountry() {
		if(country==null) country=new CountryEntity();
		return country;
	}
	public void setCountry(CountryEntity country) {
		this.country = country;
	}
	
}
