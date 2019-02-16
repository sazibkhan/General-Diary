package com.spring.dataJpa.dtos;

import java.io.Serializable;

public class CountryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long countryID;
	private String country;
	
	
	
	public Long getCountryID() {
		return countryID;
	}
	public void setCountryID(Long countryID) {
		this.countryID = countryID;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
