package com.spring.dataJpa.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.dataJpa.dtos.DistrictDTO;
import com.spring.dataJpa.entities.DistrictEntity;
import com.spring.dataJpa.entities.DivisionEntity;
import com.spring.dataJpa.repositories.DistrictRepo;

@Service
@Transactional
public class DistrictService implements Serializable{
	private static final long serialVersionUID = 1L;
		
	@Autowired
	private DistrictRepo districtRepo;
	
	//save
	public void saveOrUpdate(DistrictDTO districtDTO) {
		DistrictEntity districtEntity =new DistrictEntity();	
		DivisionEntity divisionEntity=new DivisionEntity();
		divisionEntity.setDivisionID(districtDTO.getDivisionEntite().getDivisionID());
		districtDTO.setDivisionEntite(divisionEntity);
		BeanUtils.copyProperties(districtDTO, districtEntity);
		districtRepo.save(districtEntity);
	}
	
//view
	 public List<DistrictDTO> findAllDistricts() {
		List<DistrictDTO>districtDTOList=new ArrayList<>();
		List<DistrictEntity>districtEntityList=new ArrayList<>();
		districtEntityList=districtRepo.findAll();
		for(DistrictEntity entity:districtEntityList) {
			DistrictDTO districtDTO=new DistrictDTO();
			BeanUtils.copyProperties(entity, districtDTO);
			districtDTOList.add(districtDTO);
		}
		return districtDTOList;
		}
	 
//   find All District By  DivisionId
	public List<DistrictDTO> findAllDistrictByDivisionId(Long divisionID) {
		List<DistrictDTO> districtDTOList=new ArrayList<>();
		List<DistrictEntity> districtEntityList=new ArrayList<>();
		districtEntityList=districtRepo.findByDivision(divisionID);
		
		for(DistrictEntity entity:districtEntityList) {
			DistrictDTO districtDTO=new DistrictDTO();
			BeanUtils.copyProperties(entity, districtDTO);
			districtDTOList.add(districtDTO);
		}
		return districtDTOList;
	}
	 
	
}
