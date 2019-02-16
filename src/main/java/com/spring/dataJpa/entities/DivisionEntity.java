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
@Table(name = "division")
public class DivisionEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "divisionID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long divisionID;

	@Column(name = "division", unique=true)
    private String division;
	
	@ManyToOne
	@JoinColumn(name="countryID")
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
		return country;
	}
	public void setCountry(CountryEntity country) {
		this.country = country;
	}
	
}
