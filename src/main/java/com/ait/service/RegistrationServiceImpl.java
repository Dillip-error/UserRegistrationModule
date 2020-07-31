package com.ait.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.bind.RegistrationForm;
import static com.ait.constant.AppConstants.size;
import static com.ait.constant.AppConstants.lockedStatus;
import static com.ait.constant.AppConstants.finallockedStatus;
import com.ait.entity.RegistrationEntity;
import com.ait.repository.RegistrationFormRepository;
import com.ait.utility.PwdUtility;

@Service
public class RegistrationServiceImpl implements IRegistrationService{

	@Autowired
	private RegistrationFormRepository repo;

	@Override
	public Boolean saveFormData(RegistrationForm form) {
		Boolean isSave = false;
		form.setPassword(PwdUtility.randomPwdGen(size));
		form.setAccStatus(lockedStatus);
		RegistrationEntity entity = new RegistrationEntity();
		BeanUtils.copyProperties(form,entity);
		repo.save(entity);
		isSave = true;
		return isSave;
	}

	@Override
	public Long emailValidate(String mail) {
		Long countMail = repo.countMail(mail);
		return countMail;
	}

	@Override
	public RegistrationForm getRegistrationDetailsBytempPwd(String pazzword,String email) {
		RegistrationEntity findByPassword = repo.findByPasswordAndEmail(pazzword,email);
		RegistrationForm form = null;
		
		if(findByPassword != null) {
			form = new RegistrationForm();
			BeanUtils.copyProperties(findByPassword,form);
		}
		
		return form;
	}

	@Override
	public Boolean updateFormData(RegistrationForm form) {
		Boolean isUpdate = false;
		form.setAccStatus(finallockedStatus);
		RegistrationEntity entity = new RegistrationEntity();
		BeanUtils.copyProperties(form,entity);
		repo.save(entity);
		isUpdate = true;
		return isUpdate;
	}
	
	
	

}
