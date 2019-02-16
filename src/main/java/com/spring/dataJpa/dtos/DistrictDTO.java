package com.spring.dataJpa.dtos;

import java.io.Serializable;

import com.spring.dataJpa.entities.DivisionEntity;

public class DistrictDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long districtID;
	private String district;
	
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
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
	public DivisionEntity getDivisionEntite() {
		if(divisionEntite==null) divisionEntite=new DivisionEntity();
		return divisionEntite;
	}
	public void setDivisionEntite(DivisionEntity divisionEntite) {
		this.divisionEntite = divisionEntite;
	}
	
	
	
	
}
