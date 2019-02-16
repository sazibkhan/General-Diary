package com.spring.dataJpa.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dataJpa.dtos.DivisionDTO;
import com.spring.dataJpa.entities.CountryEntity;
import com.spring.dataJpa.entities.DivisionEntity;
import com.spring.dataJpa.repositories.DivisionRepo;


@Service
@Transactional
public class DivisionService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	public DivisionRepo divisionRepo;
//Save
	public void saveDivision(DivisionDTO divisionDTO) throws Exception{
		DivisionEntity divisionEntity=new DivisionEntity();
		CountryEntity countryEntity=new CountryEntity();
		countryEntity.setCountryID(divisionDTO.getCountry().getCountryID());
		divisionDTO.setCountry(countryEntity);
		BeanUtils.copyProperties(divisionDTO, divisionEntity);
		divisionRepo.save(divisionEntity);
	}
  //View
	public List<DivisionDTO> findALlDivision() {
		List<DivisionDTO>divisionDTOList= new ArrayList<>();
		List<DivisionEntity>divisionEntiteList=new ArrayList<>();	
		divisionEntiteList=divisionRepo.findAll();
		for (DivisionEntity entite:divisionEntiteList) {
			DivisionDTO divisionDTO=new  DivisionDTO();
			BeanUtils.copyProperties(entite,divisionDTO);
			divisionDTOList.add(divisionDTO);
		}
		return divisionDTOList;
	}
	
	
	
	
    // find ALl Division By CountryId
	public List<DivisionDTO> findALlDivisionByCountryId(Long countryID) {
		List<DivisionDTO>divisionDTOList= new ArrayList<>();
		List<DivisionEntity>divisionEntiteList=new ArrayList<>();	
		divisionEntiteList=divisionRepo.findByCountryEntity(countryID); 
		
		for (DivisionEntity entite:divisionEntiteList) {
			DivisionDTO divisionDTO=new  DivisionDTO();
			BeanUtils.copyProperties(entite,divisionDTO);
			divisionDTOList.add(divisionDTO);
		}
		return divisionDTOList;
	}
	
}
