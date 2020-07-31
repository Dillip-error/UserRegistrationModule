package com.ait.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity,Serializable>{

	
}
