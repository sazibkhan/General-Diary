package com.spring.dataJpa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dataJpa.dtos.GdCategoryDTO;
import com.spring.dataJpa.entities.GdCategoryEntity;
import com.spring.dataJpa.repositories.GdCategoryRepo;

@Service
@Transactional
public class GdCategoryService {

	@Autowired
	public GdCategoryRepo categoryRepo;
	public void saveCatagory(GdCategoryDTO categotyDTO) {
		
		GdCategoryEntity categoryEntity =new GdCategoryEntity();
		BeanUtils.copyProperties(categotyDTO, categoryEntity);
		categoryRepo.save(categoryEntity);
		
	}
	
	public List<GdCategoryDTO> findAllGdCategoryList() {
		List<GdCategoryDTO>countryDTOList=new ArrayList<>();
		List<GdCategoryEntity>countryEntityList=new ArrayList<>();
		countryEntityList=categoryRepo.findAll();
		
		for(GdCategoryEntity gdEntity:countryEntityList) {
			GdCategoryDTO gdCategoryDTO=new GdCategoryDTO();
			BeanUtils.copyProperties(gdEntity, gdCategoryDTO);
			countryDTOList.add(gdCategoryDTO);
		}
		return countryDTOList;
		
	}

	

}
