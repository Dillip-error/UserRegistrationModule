package com.ait.service;

import com.ait.bind.RegistrationForm;

public interface IRegistrationService {
	
	public Boolean saveFormData(RegistrationForm form);
	
	public Long emailValidate(String mail);
	public RegistrationForm getRegistrationDetailsBytempPwd(String pazzword,String email);
	
	public Boolean updateFormData(RegistrationForm form);

}
