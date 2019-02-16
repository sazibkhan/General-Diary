package com.spring.dataJpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.dataJpa.entities.ThanaEntity;

public interface thanaRepo extends JpaRepository<ThanaEntity, Long> {
	
	@Query(value="select t from ThanaEntity t where t.districtEntity.districtID=?1")
	List<ThanaEntity> findByDistrict(Long districtID);

	
}
