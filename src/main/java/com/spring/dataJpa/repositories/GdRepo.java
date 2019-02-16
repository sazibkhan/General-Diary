package com.spring.dataJpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.dataJpa.entities.GdEntity;

public interface GdRepo extends JpaRepository<GdEntity,Long>{

	@Query(value="select t from GdEntity t where t.thanaEntity.thana=?1")
	List<GdEntity> findByThanaName(String thanaName);

}
