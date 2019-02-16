package com.spring.dataJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.dataJpa.entities.StatusEntity;

public interface StatusRepo extends JpaRepository<StatusEntity,Long>{

}
