package com.spring.dataJpa.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dataJpa.dtos.CountryDTO;
import com.spring.dataJpa.entities.CountryEntity;
import com.spring.dataJpa.repositories.CountryRepo;


@Service
@Transactional
public class CountryService implements Serializable{
	private static final long serialVersionUID = 1L;
	
public static final CountryEntity countryEntity=null;
 
 @Autowired
 public CountryRepo countryRepo;
 
 public void saveCountry(CountryDTO countryDTO)throws Exception {
	 CountryEntity countryEntity=new CountryEntity();
	 BeanUtils.copyProperties(countryDTO, countryEntity);
	 countryRepo.save(countryEntity);
	 
	 
 }

//view
 public List<CountryDTO> findAllCountry() {
	List<CountryDTO>countryDTOList=new ArrayList<>();
	List<CountryEntity>countryEntityList=new ArrayList<>();
	countryEntityList=countryRepo.findAll();
	
	for(CountryEntity entity:countryEntityList) {
		CountryDTO countryDTO=new CountryDTO();
		BeanUtils.copyProperties(entity, countryDTO);
		countryDTOList.add(countryDTO);
	}
	return countryDTOList;
	}
 
 //Edit
 	public CountryDTO findCountryById(CountryDTO countryDTO) {
		CountryDTO dto=new CountryDTO();
		CountryEntity countryEntity=new CountryEntity();
		countryEntity=countryRepo.findOne(countryEntity.getCountryID());
		BeanUtils.copyProperties(countryEntity, dto);
 		return dto;
 		
 		
 	}


	public void countryDelete(CountryDTO countryDTO) {
		countryRepo.delete(countryEntity.getCountryID());
		
	}
 			

}
