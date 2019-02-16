package com.spring.dataJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.dataJpa.entities.CountryEntity;

public interface CountryRepo extends JpaRepository<CountryEntity, Long> {

}
