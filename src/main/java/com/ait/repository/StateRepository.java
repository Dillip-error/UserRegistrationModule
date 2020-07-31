package com.ait.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity,Serializable>{

	List<StateEntity> findAllByCountryId(Integer cId);
}
