package com.ait.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ait.bind.ForgotPwdBinding;
import com.ait.bind.LoginBind;
import com.ait.bind.RegistrationForm;
import com.ait.service.ILoginService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Controller
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);  
	
	@Autowired
	private ILoginService loginService;

	@RequestMapping(value = { "/", "/login" })
	public String loginPage(Model model) {
		logger.info("==loginPage method start==");
		model.addAttribute("logInBind", new LoginBind());
		logger.info("==loginPage method End==");
		return "login";
	}

	@RequestMapping(value = { "/logindata" })
	public String validateUserNamePwd(@ModelAttribute("password") LoginBind log, RedirectAttributes attributes,
			Model model) {
		logger.debug("== validateUserNamePwd method start==");
		model.addAttribute("logInBind", new LoginBind());
		try {}
		catch(Exception e) {
			
		}
		RegistrationForm validatePwdNEmail = loginService.validatePwdNEmail(log.getPassword(), log.getEmail());

		if (validatePwdNEmail != null) {
			if (validatePwdNEmail.getAccStatus().equalsIgnoreCase("UNLOCKED")) {
				model.addAttribute("msg", "login success");
				return "login";
			} else {
				model.addAttribute("accStatus", "'Your Acccount Is Locked'");

			}
		} else {
			model.addAttribute("errorMsg", "Invalid Credentials");
			return "/login";
		}
		logger.debug("== validateUserNamePwd method End==");
		return "redirect:/";
	}
	

	@GetMapping("/forgotpwd")
	public String forgotPwd(Model model) {
		model.addAttribute("forgotPwdBinding", new ForgotPwdBinding());
		return "forgotPwd";
	}
	
	public static final String ACCOUNT_SID = "AC7ee56bb77ad3abc6338ad2e61b1927b9";
	public static final String AUTH_TOKEN = "f56f913e99cf350e3479907e50c14e06";
	
	@PostMapping("/changePwd")
	public String sendPassword(@ModelAttribute ForgotPwdBinding forgot,Model model) {
		logger.debug("==sendPassword method started==");
		try {
			
			RegistrationForm findPwd = loginService.findPwd(forgot.getEmail());
			logger.info("==findPwd method call==");
			
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			logger.info("==Twilio method initialized==");
			Message message = Message.creator(new PhoneNumber("+91"+findPwd.getPhoneNo()), new PhoneNumber("+18482218268"),
					"Thank you for use our service.. Your password is "+findPwd.getPassword()).create();
			message.getSid();
			logger.info("==New password send to register mobile number==");
			model.addAttribute("confirm", "Password sent to registered mobile ********"+findPwd.getPhoneNo().toString().substring(7,10));
			logger.debug("==sendPassword method Ended==");
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return "forgotPwd";
		
	}

}
