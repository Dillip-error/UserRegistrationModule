package com.ait.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.bind.RegistrationForm;
import com.ait.entity.RegistrationEntity;
import com.ait.repository.RegistrationFormRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private RegistrationFormRepository logRegRepo;

	@Override
	public RegistrationForm validatePwdNEmail(String pwd, String email) {

		RegistrationEntity findByPassword = logRegRepo.findByPasswordAndEmail(pwd, email);
		RegistrationForm form = null;

		if (findByPassword != null) {
			form = new RegistrationForm();
			BeanUtils.copyProperties(findByPassword, form);
		}

		return form;

	}

	@Override
	public RegistrationForm findPwd(String email) {

		RegistrationEntity findByPassword = logRegRepo.findByEmail(email);

		RegistrationForm form = null;

		if (findByPassword != null) {
			form = new RegistrationForm();
			BeanUtils.copyProperties(findByPassword, form);
		}

		return form;
	}

	

}
