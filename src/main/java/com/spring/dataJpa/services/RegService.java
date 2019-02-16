package com.spring.dataJpa.services;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dataJpa.dtos.RegDTO;
import com.spring.dataJpa.entities.RegEntitie;
import com.spring.dataJpa.repositories.RegRepo;

@Service
@Transactional
public class RegService implements Serializable{

	private static final long serialVersionUID = 1L;
	/*private static final RegEntitie regEntitie = null;*/
	@Autowired
	public RegRepo regRepo;
	public void saveUser(RegDTO regDTO)throws Exception {
		String password = DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(regDTO.getPassword().getBytes("UTF-8")));
		RegEntitie regEntitie = new RegEntitie();
		BeanUtils.copyProperties(regDTO, regEntitie);
		regEntitie.setPassword(password);
		regRepo.save(regEntitie);
		
	}
	public List<RegDTO> findAllRegNO() {
		
		List<RegDTO>regDTOList = new ArrayList<>();
		List<RegEntitie>regEntitieList=new ArrayList<>();
		regEntitieList=regRepo.findAll();
		
		for(RegEntitie regEntitie:regEntitieList) {
			RegDTO regDTO=new RegDTO(); 
			BeanUtils.copyProperties(regEntitie, regDTO);
			regDTOList.add(regDTO);
		}
		return regDTOList;
	}
	
	public RegDTO findRegById(RegDTO regDTO) {
		RegDTO regiDTO=new RegDTO();
		RegEntitie regEntitie=new RegEntitie();
		regEntitie=regRepo.findOne(regiDTO.getReagistationID());
		BeanUtils.copyProperties(regEntitie,regiDTO);
		return regiDTO;
	}
	
	public void deleteRegId(RegDTO regDTO) {
	
		regRepo.delete(regDTO.getReagistationID());
	}

	
}
