package com.spring.dataJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.dataJpa.entities.RegEntitie;

public interface RegRepo extends JpaRepository<RegEntitie, Long>{

}
