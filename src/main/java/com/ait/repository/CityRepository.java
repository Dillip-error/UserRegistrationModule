package com.ait.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Serializable>{

	List<CityEntity> findAllByStateId(Integer sId);
}
