package com.spring.dataJpa.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.spring.dataJpa.dtos.DistrictDTO;
import com.spring.dataJpa.services.DistrictService;


@Controller
@ManagedBean
@Scope("session")
public class DistrictController implements Serializable{
	private static final long serialVersionUID = 1L;


private DistrictDTO districtDTO;
private List<DistrictDTO> districtDTOList;


@Autowired
private DistrictService districtService;

//save....
public void saveOrUpdate() {
	try {
		districtService.saveOrUpdate(districtDTO);
		districtDTO=null;
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//view
public void findAllDistrict() {
	try {
		districtDTOList=new ArrayList<>();
		districtDTOList=districtService.findAllDistricts();
	} catch (Exception e) {
		e.printStackTrace();
	}	
}


public void findAllDistrictByDivisionId(Long divisionID) {
	try {
		districtDTOList=districtService.findAllDistrictByDivisionId(divisionID);
	} catch (Exception e) {
		e.printStackTrace();
	}
}


public DistrictDTO getDistrictDTO() {
	if(districtDTO==null)districtDTO=new DistrictDTO();
	return districtDTO;
}
public void setDistrictDTO(DistrictDTO districtDTO) {
	this.districtDTO = districtDTO;
}


public List<DistrictDTO> getDistrictDTOList() {
		findAllDistrict();
	return districtDTOList;
}
public void setDistrictDTOList(List<DistrictDTO> districtDTOList) {
	this.districtDTOList = districtDTOList;
}
	
	
}
