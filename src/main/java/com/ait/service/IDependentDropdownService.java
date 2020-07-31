package com.ait.service;

import java.util.Map;

public interface IDependentDropdownService {
	
	public Map<Integer,String> getAllCountryIdName();
	public Map<Integer,String> getAllStateByCountryId(Integer cId);
	public Map<Integer,String> getAllCityByStateId(Integer sId);

}
