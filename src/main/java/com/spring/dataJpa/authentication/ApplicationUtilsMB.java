package com.spring.dataJpa.authentication;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@Scope("session") 
public class ApplicationUtilsMB {
	
	public Collection<SimpleGrantedAuthority> authorities;
	
	public boolean userRoleAsAdmin;
	public boolean userRoleAsUser;
	public boolean userRoleAsGuest;
	public boolean userRoleOc;
	
	

	

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		authorities=(Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();	
	}



	public boolean isUserRoleAsAdmin() {
		for(SimpleGrantedAuthority auth:authorities) {
			if(auth.getAuthority().equals("ROLE_ADMIN")) {
				userRoleAsAdmin=true;
				break;
			}
		}
			
		
		return userRoleAsAdmin;
	}


	public void setUserRoleAsAdmin(boolean userRoleAsAdmin) {		
		this.userRoleAsAdmin = userRoleAsAdmin;
	}


	public boolean isUserRoleAsUser() {
		for(SimpleGrantedAuthority auth:authorities) {
			if(auth.getAuthority().equals("ROLE_USER")) {
				userRoleAsUser=true;
				break;
			}
		}
	
		return userRoleAsUser;
	}


	public void setUserRoleAsUser(boolean userRoleAsUser) {
		this.userRoleAsUser = userRoleAsUser;
	}

/*
	public static boolean isUserRoleAsGuest() {
		if(authorities.contains("ROLE_GUEST"))
			userRoleAsGuest=true;
		return userRoleAsGuest;
		List<String> testList=new ArrayList<>();
		testList.add("ROLE_GUEST");
		
	System.out.println(testList.contains("ROLE_GUEST"));
		
		return false;
	}

	public static void main(String[] args) {
		isUserRoleAsGuest() ;
	}
	*/
	
	public  boolean isUserRoleAsGuest() {
		if(authorities.toString().contains("ROLE_GUEST"))
			userRoleAsGuest=true;
		return userRoleAsGuest;
	}
	
	

	public void setUserRoleAsGuest(boolean userRoleAsGuest) {
		this.userRoleAsGuest = userRoleAsGuest;
	}



	public boolean isUserRoleOc() {
		if(authorities.toString().contains("ROLE_OC"))
			userRoleOc=true;
		return userRoleOc;
	}



	public void setUserRoleOc(boolean userRoleOc) {
		this.userRoleOc = userRoleOc;
	}
	

}
