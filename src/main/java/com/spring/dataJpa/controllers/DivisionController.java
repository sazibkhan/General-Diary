package com.spring.dataJpa.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.spring.dataJpa.dtos.DivisionDTO;
import com.spring.dataJpa.services.DivisionService;

@Controller
@ManagedBean
@Scope("session")
public class DivisionController implements Serializable{
	private static final long serialVersionUID = 1L;

	private DivisionDTO divDTO;
	private List<DivisionDTO>divDTOList;

	@Autowired
	private DivisionService divService;
	
	//save
	public void saveOrUpdateDivision()  {
		try {
			divService.saveDivision(divDTO);
			divDTO=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//view
	public void findAllDivisionID() {
		try {
			divDTOList=divService.findALlDivision();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public void findALlDivisionByCountryId(Long countryID) {
		try {
			divDTOList=divService.findALlDivisionByCountryId(countryID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public DivisionDTO getDivDTO() {
		if(divDTO==null)divDTO=new DivisionDTO();
		return divDTO;
	}
	public void setDivDTO(DivisionDTO divDTO) {
		this.divDTO = divDTO;
	}

	
	public List<DivisionDTO> getDivDTOList() {
		findAllDivisionID();
		return divDTOList;
	}
	public void setDivDTOList(List<DivisionDTO> divDTOList) {
		this.divDTOList = divDTOList;
	}
}
