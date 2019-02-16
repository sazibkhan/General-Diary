package com.spring.dataJpa.services;


import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dataJpa.dtos.UsersDTO;
import com.spring.dataJpa.entities.Users;
import com.spring.dataJpa.entities.UsersRole;
import com.spring.dataJpa.repositories.UsersRepository;
import com.spring.dataJpa.repositories.UsersRoleRepository;


@Service
@Transactional
public class UsersService{
	
@Autowired
private UsersRepository usersRepository;
@Autowired
private UsersRoleRepository usersRoleRepository;



public void saveOrUpdate(UsersDTO usersDTO) throws Exception{
	Users users=new Users();
	UsersRole usersRole=new UsersRole();
	usersRole.setUsername(usersDTO.getUsername());
	if(usersDTO.getOcIdentificationId().equals(null)) {
		usersRole.setRoleName("ROLE_OC"); 
	}else {
		usersRole.setApproveStatus(true); 
		usersRole.setRoleName("ROLE_GUEST"); 
	}
	
	
	usersRole.setApproveStatus(false);
	BeanUtils.copyProperties(usersDTO, users);	
	String password = DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(usersDTO.getPassword().getBytes("UTF-8")));
	users.setPassword(password); 
	users.setEnabled(true); 
	usersRepository.save(users);
	usersRoleRepository.save(usersRole);

}

public List<UsersDTO> findAllUsers() { 
	List<UsersDTO> userDTOList=new ArrayList<>();
	List<Users> userList=new ArrayList<>();
	userList=usersRepository.findAll();
	for(Users user:userList) {
		UsersDTO UserDTO=new UsersDTO();
		BeanUtils.copyProperties(user, UserDTO);	
		
		userDTOList.add(UserDTO);
	}
	
	return userDTOList;
	
}

public UsersDTO findById(UsersDTO usersDTO) {
UsersDTO userDTO=new UsersDTO();
Users users=new Users();
users=usersRepository.findOne(userDTO.getId());
BeanUtils.copyProperties(users, userDTO);
return userDTO;	
}

public void deleteUser(UsersDTO usersDTO) {
	usersRepository.delete(usersDTO.getId()); 
	
}

public List<UsersDTO> findALllLoginByThanaId(Long thanaID) {
	
	return null;
}

public List<UsersRole> findAllUserRoles() {
	List<UsersRole> usersRoleList=new ArrayList<>();
	try {
		usersRoleList=usersRoleRepository.findByApproveStatus(true);	
	}catch(Exception e) {
		e.printStackTrace(); 
	}
	return usersRoleList;
}

public List<UsersRole> findAllOcPendingList() {
	List<UsersRole> ocPendingList=new ArrayList<>();
	try {
		ocPendingList=usersRoleRepository.findByApproveStatus(false);	
		
		for(UsersRole role:ocPendingList) {
			Users users=usersRepository.findByUsername(role.getUsername());
			
			role.setOcIdentificationId(users.getOcIdentificationId());
		}
	}catch(Exception e) {
		e.printStackTrace(); 
	}
	return ocPendingList;
}

public void approveAsOc(String username) {
try {
	UsersRole usersRole=new UsersRole();
	usersRole=usersRoleRepository.findByUsername(username).get(0); 
	usersRole.setRoleName("ROLE_OC"); 
	usersRole.setApproveStatus(true);
}catch(Exception e) {
	
}
	
}
}
