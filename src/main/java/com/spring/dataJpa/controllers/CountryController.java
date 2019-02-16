package com.spring.dataJpa.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.spring.dataJpa.dtos.CountryDTO;
import com.spring.dataJpa.services.CountryService;

@Controller
@ManagedBean
@Scope("session")
public class CountryController implements Serializable{

	private static final long serialVersionUID = 1L;

	private CountryDTO countryDTO;
	private List<CountryDTO>CountryDTOList;
	
	@Autowired
	public CountryService countryService;
	
	//Save
public void saveCountry() {
	try {
		countryService.saveCountry(countryDTO);
		countryDTO=null;
	} catch (Exception e) {
	 e.printStackTrace();
	}
}
//View
public void findAllCountryList() {
	try {
		CountryDTOList=countryService.findAllCountry();
	} catch (Exception e) {
		e.printStackTrace();
	}
}	
//Edit
public void findCountryById() {
	try {
		countryDTO=countryService.findCountryById(countryDTO);
	} catch (Exception e) {
	e.printStackTrace();
	}
}
//Delete
public void countryDelete() {
	try {
		countryService.countryDelete(countryDTO);
		countryDTO = new CountryDTO();
	} catch (Exception e) {
	e.printStackTrace();
	}
}



	public CountryDTO getCountryDTO() {
		if(countryDTO==null)countryDTO=new CountryDTO();
		return countryDTO;
	}

	public void setCountryDTO(CountryDTO countryDTO) {
		this.countryDTO = countryDTO;
	}
	
	public List<CountryDTO> getCountryDTOList() {
		findAllCountryList();
		return CountryDTOList;
	}
	public void setCountryDTOList(List<CountryDTO> countryDTOList) {
		CountryDTOList = countryDTOList;
	}
}
