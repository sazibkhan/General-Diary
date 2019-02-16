package com.spring.dataJpa.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.spring.dataJpa.dtos.ThanaDTO;
import com.spring.dataJpa.services.ThanaService;

@Controller
@ManagedBean
@Scope("session")
public class ThanaController implements Serializable{

	private static final long serialVersionUID = 1L;
	private ThanaDTO thanaDTO;
	private List<ThanaDTO>thanaDTOList;
	
	
	
	@Autowired
	private ThanaService thanaService;

	//Save
	public void saveOrUpdate() {
		try {
			thanaService.saveOrUpdate(thanaDTO);
			thanaDTO=null;
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	//View
	public void findALlThanaList() {
		try {
			thanaDTOList=thanaService.findALlThanaList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Edit
	
	
	
	
	public ThanaDTO getThanaDTO() {
		if(thanaDTO==null)thanaDTO=new ThanaDTO();
		return thanaDTO;
	}
	
	public void setThanaDTO(ThanaDTO thanaDTO) {
		this.thanaDTO = thanaDTO;
	}

	
	public List<ThanaDTO> getThanaDTOList() {
		findALlThanaList();
		return thanaDTOList;
	}
	public void setThanaDTOList(List<ThanaDTO> thanaDTOList) {
		this.thanaDTOList = thanaDTOList;
	}
	
	
}
