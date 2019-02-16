package com.spring.dataJpa.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.spring.dataJpa.dtos.StatusDTO;
import com.spring.dataJpa.services.StatusService;

@Controller
@ManagedBean
@Scope("session")
public class StatusController implements Serializable{
	private static final long serialVersionUID = 1L;

	private StatusDTO statusDTO;
	private List<StatusDTO> statusDTOList;
	
	@Autowired
	private StatusService statusService;

	
	public void saveOrUpdateStatus() {
		try {
			statusService.saveOrUpdateStatus(statusDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
	
	
	
	
	
	
	public StatusDTO getStatusDTO() {
		if(statusDTO==null)statusDTO=new StatusDTO();
		return statusDTO;
	}

	public void setStatusDTO(StatusDTO statusDTO) {
		this.statusDTO = statusDTO;
	}

	public List<StatusDTO> getStatusDTOList() {
		return statusDTOList;
	}

	public void setStatusDTOList(List<StatusDTO> statusDTOList) {
		this.statusDTOList = statusDTOList;
	}
	
	
	
	
	
	
	
	
	
}
