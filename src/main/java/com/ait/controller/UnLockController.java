package com.ait.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ait.bind.RegistrationForm;
import com.ait.bind.UnLockBind;
import com.ait.service.IRegistrationService;

@Controller
public class UnLockController {

	private static Logger logger = LoggerFactory.getLogger(UnLockController.class);

	@Autowired
	private IRegistrationService regService;

	@GetMapping("/finallogin")
	public String Login(@RequestParam("email") String mail, @RequestParam("OTP") String otp, Model model) {
		logger.info("==Login method Start==");

		logger.info("==UnLockBind Objec created==");
		UnLockBind bind = new UnLockBind();
		model.addAttribute("mail", mail);
		model.addAttribute("otp", otp);
		model.addAttribute("unLockBind", bind);
		logger.info("==Login method End==");

		return "unlock";

	};

	@PostMapping("/read")
	public String readForm(@ModelAttribute("confirmPwd") UnLockBind bin, Model model) {
		logger.info("==readForm method Start==");
		logger.info("==UnLockBind object created==");
		UnLockBind bind = new UnLockBind();
		logger.info("==send to UI==");
		model.addAttribute("unLockBind", bind);
		try {
			logger.info("==inside try block==");
			RegistrationForm registrationDetailsBytempPwd = regService.getRegistrationDetailsBytempPwd(bin.getTempPwd(),
					bin.getEmail());
			logger.info("==getRegistrationDetailsBytempPwd method call==");
			
			
			if (registrationDetailsBytempPwd != null) {
				logger.info("==IF condition true then inside if condition==");
				registrationDetailsBytempPwd.setPassword(bin.getConfirmPwd());
				logger.info("==Password set==");
				Boolean updateFormData = regService.updateFormData(registrationDetailsBytempPwd);
				logger.info("==updateFormData method call==");
				if (updateFormData != null) {
					return "confirm";
				}

			}
		} catch (Exception e) {
			logger.error(e.getMessage());

		}

		model.addAttribute("errorMsg", "Please Check Your  TempPassword");
		bind.setEmail(bin.getEmail());
		
		return "unlock";

	};

}
