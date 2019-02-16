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
@Table(name="district")
public class DistrictEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="districtID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long districtID;
	
	@Column(name="District",unique=true)
	private String district;
	
	@ManyToOne
	@JoinColumn(name="divisionID")
	private DivisionEntity divisionEntite;

	
	
	public Long getDistrictID() {
		return districtID;
	}
	public void setDistrictID(Long districtID) {
		this.districtID = districtID;
	}

	public String getDistrict() {
		return district;
	}
	public void setDistrict(String string) {
		this.district = string;
	}
	public DivisionEntity getDivisionEntite() {
		return divisionEntite;
	}
	public void setDivisionEntite(DivisionEntity divisionEntite) {
		this.divisionEntite = divisionEntite;
	}


}
