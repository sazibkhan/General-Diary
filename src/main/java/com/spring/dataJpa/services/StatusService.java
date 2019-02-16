package com.spring.dataJpa.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dataJpa.dtos.StatusDTO;
import com.spring.dataJpa.entities.StatusEntity;
import com.spring.dataJpa.repositories.StatusRepo;

@Service
@Transactional
public class StatusService {

	@Autowired
	private StatusRepo statusRepo;
	
	public void saveOrUpdateStatus(StatusDTO statusDTO) {
		StatusEntity   statusEntity=new StatusEntity();
		BeanUtils.copyProperties(statusDTO, statusEntity);
		statusRepo.save(statusEntity);
		
	}

	
}
