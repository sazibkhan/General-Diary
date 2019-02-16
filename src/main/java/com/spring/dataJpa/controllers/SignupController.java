package com.spring.dataJpa.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.spring.dataJpa.dtos.UsersDTO;
import com.spring.dataJpa.entities.UsersRole;
import com.spring.dataJpa.services.UsersService;



@Controller
@ManagedBean
@Scope
public class SignupController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public UsersDTO usersDTO;
	public List<UsersDTO> usersList;
	public List<UsersRole> usersRoleList;
	public Set<String> uniqueRoleList;
	public List<UsersRole> ocPendigList;
	

	@Autowired
	private UsersService usersService;
	
	public String saveOrUpdate() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
		
			usersService.saveOrUpdate(usersDTO);
			usersDTO=null;
			context.addMessage(null, new FacesMessage("Data Save Success"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login.xhtml?faces-redirect=true";
	}
	
	public void findAllUser() {		
		try {
			usersList = new ArrayList<>();
			usersList=usersService.findAllUsers();
		} catch (Exception e) {
		e.printStackTrace();
		}		
	}
	
	public void findAllUsersRole() {
		usersRoleList=new ArrayList<>();
		try {
			usersRoleList=usersService.findAllUserRoles();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void findById() {
		try {
			usersDTO = usersService.findById(usersDTO);
		} catch (Exception e) {
		e.printStackTrace();
		}
	
	}
	
	public void deleteUser() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			usersService.deleteUser(usersDTO);
			context.addMessage(null, new FacesMessage("Delete Success"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void approveOcRole() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			usersService.approveAsOc(usersDTO.getUsername());
			context.addMessage(null, new FacesMessage("Approved"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void findAllOcPendingList() {
		ocPendigList=new ArrayList<>();
		ocPendigList=usersService.findAllOcPendingList();
	}

	public void findALllLoginByThanaId(Long thanaID) {
		usersList=usersService.findALllLoginByThanaId(thanaID);
		
	}
	
	public UsersDTO getUsersDTO() {
		if(usersDTO==null) usersDTO=new UsersDTO();
		return usersDTO;
	}

	public void setUsersDTO(UsersDTO usersDTO) {
		this.usersDTO = usersDTO;
	}

	public List<UsersDTO> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<UsersDTO> usersList) {
		this.usersList = usersList;
	}

	public List<UsersRole> getUsersRoleList() {
		findAllUsersRole();
		return usersRoleList;
	}

	public void setUsersRoleList(List<UsersRole> usersRoleList) {
		
		this.usersRoleList = usersRoleList;
	}

	public Set<String> getUniqueRoleList() {
		getUsersRoleList();
		uniqueRoleList=new HashSet<>();
		for(UsersRole role:usersRoleList) {
			uniqueRoleList.add(role.getRoleName());
		}
		return uniqueRoleList;
	}

	public void setUniqueRoleList(Set<String> uniqueRoleList) {
		this.uniqueRoleList = uniqueRoleList;
	}

	public List<UsersRole> getOcPendigList() {
		findAllOcPendingList();
		return ocPendigList;
	}

	public void setOcPendigList(List<UsersRole> ocPendigList) {
		this.ocPendigList = ocPendigList;
	}
	
	

}
