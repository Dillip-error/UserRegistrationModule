package com.ait.service;

import com.ait.bind.RegistrationForm;

public interface ILoginService {
	
	public RegistrationForm validatePwdNEmail(String pwd,String email);
	public RegistrationForm findPwd(String email);

}
