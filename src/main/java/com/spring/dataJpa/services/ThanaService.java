package com.spring.dataJpa.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dataJpa.dtos.ThanaDTO;
import com.spring.dataJpa.entities.DistrictEntity;
import com.spring.dataJpa.entities.ThanaEntity;
import com.spring.dataJpa.repositories.thanaRepo;

@Service
@Transactional
public class ThanaService implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Autowired
	private thanaRepo thanaRepo;
	//save
	public void saveOrUpdate(ThanaDTO thanaDTO) throws Exception{
	ThanaEntity thanaEntity=new ThanaEntity();
	DistrictEntity districtEntity=new DistrictEntity();
	districtEntity.setDistrictID(thanaDTO.getDistrictEntity().getDistrictID());
	thanaDTO.setDistrictEntity(districtEntity);
	BeanUtils.copyProperties(thanaDTO, thanaEntity);
		thanaRepo.save(thanaEntity);
	}

//view
	public List<ThanaDTO> findALlThanaList() {
	List<ThanaDTO>thanaDTOList=new ArrayList<>();
	List<ThanaEntity>thanaEntitieList=new ArrayList<>();
	thanaEntitieList=thanaRepo.findAll();
	
	for(ThanaEntity entiry:thanaEntitieList) {
		ThanaDTO thanaDTO=new ThanaDTO();
		BeanUtils.copyProperties(entiry,thanaDTO);
		thanaDTOList.add(thanaDTO);
	}
		return thanaDTOList;
	}

	//	edit
	

	//find All Thana By DistrictId
	public List<ThanaDTO> findAllThanaByDistrictId(Long districtID) {
		List<ThanaDTO>thanaDTOList=new ArrayList<>();
		List<ThanaEntity>thanaEntitieList=new ArrayList<>();
		thanaEntitieList=thanaRepo.findByDistrict(districtID);
		
		for(ThanaEntity entiry:thanaEntitieList) {
			ThanaDTO thanaDTO=new ThanaDTO();
			BeanUtils.copyProperties(entiry,thanaDTO);
			thanaDTOList.add(thanaDTO);
		}
			return thanaDTOList;
		}
 		
}
