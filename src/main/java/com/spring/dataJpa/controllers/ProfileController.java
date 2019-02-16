package com.spring.dataJpa.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.spring.dataJpa.dtos.ProfileDTO;
import com.spring.dataJpa.services.ProfileService;
import com.spring.dataJpa.upload.util.Upload;
import com.spring.dataJpa.upload.util.UploadImpl;

@Controller
@ManagedBean
@Scope("session")
public class ProfileController implements Serializable{
	private static final long serialVersionUID = 1L;

	private ProfileDTO profileDTO;
	@Autowired
	private ProfileService profileService;
	
	private List<ProfileDTO> profileDTOList;
	private UploadedFile uploadFile;
	
	//save
	public void saveOrUpdateUserProfile() {
		FacesContext context=FacesContext.getCurrentInstance();
		String fileName=uploadFile.getFileName();
		try {
			Upload upload=new UploadImpl();
			upload.upload("UserPic", fileName, uploadFile);
			profileDTO.setPhotoPath(fileName);
			boolean b=profileService.isSaveOrUpdateUserProfile(profileDTO);
			 if (b) {              
	                context.addMessage(null, new FacesMessage("Data saved Successfully!"));
	            }else{                
	            	context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sorry! Data could not be saved Successfully!",""));
	            }
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	public void findAllProfileList() {

		try {
			profileDTOList=profileService.findAllProfileList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ProfileDTO getProfileDTO() {
		if(profileDTO==null)profileDTO=new ProfileDTO();
		return profileDTO;
	}

	public void setProfileDTO(ProfileDTO profileDTO) {
		this.profileDTO = profileDTO;
	}

	public List<ProfileDTO> getProfileDTOList() {
		findAllProfileList();
		return profileDTOList;
	}

	public void setProfileDTOList(List<ProfileDTO> profileDTOList) {
		this.profileDTOList = profileDTOList;
	}


	public UploadedFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(UploadedFile uploadFile) {
		this.uploadFile = uploadFile;
	}

}
