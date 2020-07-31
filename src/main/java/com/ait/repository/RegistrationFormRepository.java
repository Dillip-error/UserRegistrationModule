package com.ait.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ait.entity.RegistrationEntity;

public interface RegistrationFormRepository extends JpaRepository<RegistrationEntity, Serializable> {

	public Long countByEmail(String mail);

	@Query("SELECT COUNT(email) FROM RegistrationEntity  WHERE email=:mail")
	public Long countMail(String mail);

	public RegistrationEntity findByPasswordAndEmail(String pazzword,String email);
	
	public RegistrationEntity findByEmail(String email);
	
	
	
}
