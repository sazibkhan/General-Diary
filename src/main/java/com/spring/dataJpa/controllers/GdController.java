package com.spring.dataJpa.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.spring.dataJpa.dtos.DistrictDTO;
import com.spring.dataJpa.dtos.DivisionDTO;
import com.spring.dataJpa.dtos.GdDTO;
import com.spring.dataJpa.dtos.ThanaDTO;
import com.spring.dataJpa.services.DistrictService;
import com.spring.dataJpa.services.DivisionService;
import com.spring.dataJpa.services.GdService;
import com.spring.dataJpa.services.ThanaService;

@Controller
@ManagedBean
@Scope("session")
public class GdController implements Serializable{
	private static final long serialVersionUID = 1L;

	private GdDTO gdDTO;
	private List<GdDTO>gdDTOList;
	private List<GdDTO> thahaWiseGdDtoList;
	
	@Autowired
	private GdService gdService;
	
	@Autowired
	private DivisionService divisionService;
	@Autowired
	private DistrictService districtService;
	@Autowired
	private ThanaService thanaService;
	
	
	List<DivisionDTO> divisionList;
	List<DistrictDTO> distictList;
	List<ThanaDTO> thanaList;
	
	
	//save
	public void gdSaveOrUpdate() {
		try {
			gdService.gdSaveOrUpdate(gdDTO);
			gdDTO=null;
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	//View
	public void findAllGdList() {
		try {
			gdDTOList=gdService.findAllGdList();
		} catch (Exception e) {
		e.printStackTrace();
		}	
	}
	
	public void findThanaWiseGdList() {
		HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		String thanaName=(String) session.getAttribute("thanaName");
		try { 
			thahaWiseGdDtoList=gdService.findThanaWiseGdList(thanaName);
			
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	
	//Edit
	/*public void findGdByID() {
		try {
			gdDTO=gdService.findGdByID(gdDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Delete
	public void deleteGD() {
		try {
			gdService.deleteGD(gdDTO);
			gdDTO=new GdDTO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	public void updateSeenStatus() {
		try {
			gdService.updateSeenStatus(gdDTO.getGdID());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public GdDTO getGdDTO() {
		if (gdDTO==null)gdDTO=new GdDTO();
		return gdDTO;
	}
	public void setGdDTO(GdDTO gdDTO) {
		this.gdDTO = gdDTO;
	}

	public List<GdDTO> getGdDTOList() {
		findAllGdList();
		return gdDTOList;
	}
	public void setGdDTOList(List<GdDTO> gdDTOList) {
		this.gdDTOList = gdDTOList;
	}

	
	
	
	public void findAllDivisionByCountryId() {
		divisionList=new ArrayList<>();
		divisionList=divisionService.findALlDivisionByCountryId(gdDTO.getCountryEntity().getCountryID()); 
	}
	
	public void findAllDistrictByDivisionId() {
	 distictList=new ArrayList<>();
	 distictList=districtService.findAllDistrictByDivisionId(gdDTO.getDivisionEntity().getDivisionID());
	
	 
	}
	
	public void findAllThanaByDistrictId() {
		thanaList=new ArrayList<>();
	     thanaList=thanaService.findAllThanaByDistrictId(gdDTO.getDistrictEntity().getDistrictID());
	}
	
	
	
	//Division
	public List<DivisionDTO> getDivisionList() {
		findAllDivisionByCountryId();
		return divisionList;
	}
	public void setDivisionList(List<DivisionDTO> divisionList) {
		this.divisionList = divisionList;
	}
	
	//District
	public List<DistrictDTO> getDistictList() {
		findAllDistrictByDivisionId();
		return distictList;
	}
	public void setDistictList(List<DistrictDTO> distictList) {
		this.distictList = distictList;
	}
	//Thana
	public List<ThanaDTO> getThanaList() {
		findAllThanaByDistrictId();
		return thanaList;
	}
	public void setThanaList(List<ThanaDTO> thanaList) {
		this.thanaList = thanaList;
	}

	public List<GdDTO> getThahaWiseGdDtoList() {
		findThanaWiseGdList();
		return thahaWiseGdDtoList;
	}

	public void setThahaWiseGdDtoList(List<GdDTO> thahaWiseGdDtoList) {
		this.thahaWiseGdDtoList = thahaWiseGdDtoList;
	}
	
	
}




