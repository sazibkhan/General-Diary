package com.spring.dataJpa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.dataJpa.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
    
  public  Users findByUsernameAndPasswordAndEnabled(String username,String password,boolean enabled);
  public  Users findByUsername(String username);
}
 