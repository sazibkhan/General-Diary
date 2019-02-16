package com.spring.dataJpa.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dataJpa.dtos.GdDTO;
import com.spring.dataJpa.entities.CountryEntity;
import com.spring.dataJpa.entities.DistrictEntity;
import com.spring.dataJpa.entities.DivisionEntity;
import com.spring.dataJpa.entities.GdEntity;
import com.spring.dataJpa.entities.ThanaEntity;
import com.spring.dataJpa.repositories.GdRepo;

@Service
@Transactional
public class GdService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final GdEntity gdEntitie=null;
	@Autowired
	public GdRepo gdRepo;
	
	
	//Save
	public void gdSaveOrUpdate(GdDTO gdDTO) throws Exception{
		GdEntity gdEntitie=new GdEntity();
		
	CountryEntity countryEntity=new CountryEntity();
	countryEntity.setCountryID(gdDTO.getCountryEntity().getCountryID());
	gdDTO.setCountryEntity(countryEntity);
		
	DivisionEntity divisionEntity= new DivisionEntity();
	divisionEntity.setDivisionID(gdDTO.getDivisionEntity().getDivisionID());
	gdDTO.setDivisionEntity(divisionEntity);
	
	DistrictEntity districtEntity= new DistrictEntity();
	districtEntity.setDistrictID(gdDTO.getDistrictEntity().getDistrictID());
	gdDTO.setDistrictEntity(districtEntity);
	
	ThanaEntity thanaEntity=new ThanaEntity();
	thanaEntity.setThanaId(gdDTO.getThanaEntity().getThanaId());
	gdDTO.setThanaEntity(thanaEntity);
	
		BeanUtils.copyProperties(gdDTO, gdEntitie);
		gdRepo.save(gdEntitie);
		
	}


	

//View
	public List<GdDTO> findAllGdList(){
		List<GdDTO>gdDTOList =new ArrayList<>();
		List<GdEntity>gdEntityList =new ArrayList<>();
		gdEntityList=gdRepo.findAll();
		
		for(GdEntity gdEntity:gdEntityList) {
			GdDTO gdDTO=new GdDTO();
			BeanUtils.copyProperties(gdEntity, gdDTO);
			
			gdDTOList.add(gdDTO);
		}
		return gdDTOList;
	}



/*
//Edit
	public GdDTO findGdByID(GdDTO gdDTO) {
	GdDTO dto=new GdDTO();
	GdEntity gdEntity=new GdEntity();
	gdEntity=gdRepo.findOne(gdEntity.getGdID());
		
		
		return dto;
	}



	//Delete
	public void deleteGD(GdDTO gdDTO) {
		gdRepo.delete(gdEntitie.getGdID());
		
	}
*/



	public List<GdDTO> findThanaWiseGdList(String thanaName) {
		List<GdDTO>gdDTOList =new ArrayList<>();
		List<GdEntity>gdEntityList =new ArrayList<>();
		gdEntityList=gdRepo.findByThanaName(thanaName);
		
		for(GdEntity gdEntity:gdEntityList) {
			GdDTO gdDTO=new GdDTO();
			BeanUtils.copyProperties(gdEntity, gdDTO);
			
			gdDTOList.add(gdDTO);
		}
		return gdDTOList;
	}




	public void updateSeenStatus(Long gdID) {
		GdEntity gdEntity=gdRepo.findOne(gdID);
		gdEntity.setSeenStatus(true); 
		
	}




	
}
