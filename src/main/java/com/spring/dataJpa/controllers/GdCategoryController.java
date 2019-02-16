package com.spring.dataJpa.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.spring.dataJpa.dtos.GdCategoryDTO;
import com.spring.dataJpa.services.GdCategoryService;


@Controller
@ManagedBean
@Scope("session")
public class GdCategoryController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private GdCategoryDTO categotyDTO;
	private List<GdCategoryDTO>categotyDTOList;
	
	@Autowired
	private GdCategoryService categotyService;

	
	
	
	
	public void saveOrUpdateCategory() {
		try {
			categotyService.saveCatagory(categotyDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void findAllGdCategoryList() {
		try {
			categotyDTOList=categotyService.findAllGdCategoryList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	
	
	
	public GdCategoryDTO getCategotyDTO() {
		if(categotyDTO==null)categotyDTO=new GdCategoryDTO();
		return categotyDTO;
	}

	public void setCategotyDTO(GdCategoryDTO categotyDTO) {
		this.categotyDTO = categotyDTO;
	}

	public List<GdCategoryDTO> getCategotyDTOList() {
		findAllGdCategoryList();
		return categotyDTOList;
	}

	public void setCategotyDTOList(List<GdCategoryDTO> categotyDTOList) {
		this.categotyDTOList = categotyDTOList;
	}
	
	
	
	
	
	

}
