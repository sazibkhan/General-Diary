package com.spring.dataJpa.dtos;

import java.io.Serializable;

import com.spring.dataJpa.entities.DistrictEntity;

public class ThanaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long thanaId;
	private String thana;
	
	
	private DistrictEntity districtEntity;
	
	
	
	
	public String getThana() {
		return thana;
	}
	public void setThana(String thana) {
		this.thana = thana;
	}

	
	public Long getThanaId() {
		return thanaId;
	}
	public void setThanaId(Long thanaId) {
		this.thanaId = thanaId;
	}
	public DistrictEntity getDistrictEntity() {
		if(districtEntity==null)districtEntity=new DistrictEntity();
		return districtEntity;
	}
	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
	}

	
	
	
}
