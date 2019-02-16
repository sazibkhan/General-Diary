package com.spring.dataJpa.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.spring.dataJpa.dtos.RegDTO;
import com.spring.dataJpa.jsper.util.JasperUtil;
import com.spring.dataJpa.services.RegService;

@Controller
@ManagedBean
@Scope("session")
public class RegController implements Serializable{

	private static final long serialVersionUID = 1L;

	private RegDTO regDTO;
	private List<RegDTO>regDTOList;
	
	
	@Autowired
	private RegService regService;
	
	
	public void saveOrUpdateUser() {
		
		try {
			regService.saveUser(regDTO);
			regDTO=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void findAllRegNO() {
		
		try {
			regDTOList=regService.findAllRegNO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void findRegById() {
		try {
			regDTO=regService.findRegById(regDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteReg() {
		
		regService.deleteRegId(regDTO); 
	}
	
	public void downloadRagList() {
		Map<String, Object>map=new HashMap<>();
		map.put("UniversityName", "DaffodilInternationalUniversity");
		map.put("ReportType", "Registation List");
		JasperUtil jasperUtil=new JasperUtil();
		try {
			jasperUtil.jasperPrint(regDTOList, map, "com/spring/dataJpa/jsper/RegistationFrom.jasper", "regList");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public RegDTO getRegDTO() {
		if(regDTO==null)regDTO=new RegDTO();
		/*if(regDTO == null) {
			regDTO = new RegDTO();
		}*/
		return regDTO;
	}

	public void setRegDTO(RegDTO regDTO) {
		this.regDTO = regDTO;
	}
	
	
	public List<RegDTO> getRegDTOList() {
		findAllRegNO();
		return regDTOList;
	}
	public void setRegDTOList(List<RegDTO> regDTOList) {
		this.regDTOList = regDTOList;
	}
	
}
