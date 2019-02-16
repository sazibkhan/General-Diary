package com.spring.dataJpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="countryTable")
public class CountryEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="countryID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long countryID;
	

	@Column(name="Country", unique=true)
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
