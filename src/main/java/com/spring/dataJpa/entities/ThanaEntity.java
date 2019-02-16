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
@Table(name="thana")
public class ThanaEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="thanaId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long thanaId;
	
	@Column(name="Thana")
	private String thana;
	
	
	@ManyToOne
	@JoinColumn(name="districtID")
	private DistrictEntity districtEntity;
	

	public Long getThanaId() {
		return thanaId;
	}
	public void setThanaId(Long thanaId) {
		this.thanaId = thanaId;
	}
	public String getThana() {
		return thana;
	}
	public void setThana(String thana) {
		this.thana = thana;
	}

	
	public DistrictEntity getDistrictEntity() {
		return districtEntity;
	}
	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
	}
	

}
