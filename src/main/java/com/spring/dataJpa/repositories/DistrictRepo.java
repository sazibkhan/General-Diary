package com.spring.dataJpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.dataJpa.entities.DistrictEntity;


public interface DistrictRepo extends JpaRepository<DistrictEntity,Long>{

	@Query(value="select t from DistrictEntity t where t.divisionEntite.divisionID=?1")
	List<DistrictEntity> findByDivision(Long divisionID);

}
