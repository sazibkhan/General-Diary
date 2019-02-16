package com.spring.dataJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.dataJpa.entities.ProfileEntity;

public interface ProfileRepo extends JpaRepository<ProfileEntity,Long> {

}
