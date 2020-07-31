package com.ait.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.entity.CityEntity;
import com.ait.entity.CountryEntity;
import com.ait.entity.StateEntity;
import com.ait.repository.CityRepository;
import com.ait.repository.CountryRepository;
import com.ait.repository.StateRepository;

@Service
public class DependentDropdownServiceImpl 
                                   implements IDependentDropdownService{

	@Autowired
	private CountryRepository countryRepo;
	@Autowired
	private StateRepository stateRepo;
	@Autowired
	private CityRepository cityRepo;
	
	
	@Override
	public Map<Integer, String> getAllCountryIdName() {
		Map<Integer,String> map = new LinkedHashMap<Integer,String>();
		List<CountryEntity> findAll = countryRepo.findAll();
		findAll.forEach(countryEntity ->{
			map.put(countryEntity.getCountryId(),countryEntity.getCountryName());
		});
		return map;
	}

	@Override
	public Map<Integer, String> getAllStateByCountryId(Integer cId) {
		Map<Integer,String> map = new LinkedHashMap<>();
		List<StateEntity> findAllByCountryId = stateRepo.findAllByCountryId(cId);
		findAllByCountryId.forEach(stateEntity ->{
			map.put(stateEntity.getStateId(),stateEntity.getStateName());
		});
		return map;
	}

	@Override
	public Map<Integer, String> getAllCityByStateId(Integer sId) {
		Map<Integer,String> map = new LinkedHashMap<>();
		List<CityEntity> findAllByStateId = cityRepo.findAllByStateId(sId);
		findAllByStateId.forEach(cityEntity ->{
			map.put(cityEntity.getCityId(),cityEntity.getCityName());
		});
		return map;
	}

}
