package com.spring.dataJpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.dataJpa.entities.DivisionEntity;


public interface DivisionRepo extends JpaRepository<DivisionEntity,Long>{

	
	@Query(value="select t from DivisionEntity t where t.country.countryID=?1")
	List<DivisionEntity> findByCountryEntity(Long countryID);
	
	
	
}