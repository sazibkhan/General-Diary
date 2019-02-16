package com.spring.dataJpa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dataJpa.dtos.ProfileDTO;
import com.spring.dataJpa.entities.ProfileEntity;
import com.spring.dataJpa.repositories.ProfileRepo;


@Service
@Transactional
public class ProfileService {

	@Autowired
	public ProfileRepo profileRepo;
	
	public boolean isSaveOrUpdateUserProfile(ProfileDTO profileDTO) throws Exception {
		ProfileEntity profileEntity=new ProfileEntity();
		BeanUtils.copyProperties(profileDTO,profileEntity);
		profileRepo.save(profileEntity);
		return true;
	}

	public List<ProfileDTO> findAllProfileList() {
		List<ProfileDTO>profileDTOList =new ArrayList<>();
		List<ProfileEntity> profileEntityList =new ArrayList<>();
		profileEntityList=profileRepo.findAll();
		
		for(ProfileEntity entity:profileEntityList) {
			
			ProfileDTO profileDTO=new ProfileDTO();
			BeanUtils.copyProperties(entity, profileDTO);
			profileDTOList.add(profileDTO);
			
		}
		
		
		return profileDTOList;
	}

	
	
}
