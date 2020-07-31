package com.ait.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ait.bind.RegistrationForm;


import static com.ait.constant.AppConstants.METHOD_EXECUTION_STATED;
import static com.ait.constant.AppConstants.METHOD_EXECUTION_ENDED;
import static com.ait.constant.AppConstants.REGISTRATION_PAGE_LOADED;
import static com.ait.constant.AppConstants.ALL_CITY_LOADED;
import static com.ait.constant.AppConstants.ALL_COUNTRY_LOADED;
import static com.ait.constant.AppConstants.ALL_STATE_LOADED;
import com.ait.entity.RegistrationEntity;
import com.ait.service.IDependentDropdownService;
import com.ait.service.IRegistrationService;
import com.ait.utility.MailSenderUtils;

@Controller
@RequestMapping(value = "/reg")
public class RegistrationController {

	private static Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	private IRegistrationService service;
	@Autowired
	private IDependentDropdownService dservice;
	@Autowired
	private MailSenderUtils mailUtils;

	@GetMapping(value = { "/create", "/registration" })
	public String registrationForm(Model model) {
		logger.info(METHOD_EXECUTION_STATED);
		try {
			Map<Integer, String> allCountryIdName = dservice.getAllCountryIdName();
			model.addAttribute("registrationEntity", new RegistrationEntity());
			model.addAttribute("allCountryIdName", allCountryIdName);
			logger.info(ALL_COUNTRY_LOADED);
			logger.info(REGISTRATION_PAGE_LOADED);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.info(METHOD_EXECUTION_ENDED);
		return "registrationForm";

	}

	@GetMapping("/getStates")
	@ResponseBody
	public Map<Integer, String> getStateByCountryId(@RequestParam("conId") Integer countryId) {
		logger.info(METHOD_EXECUTION_STATED);
		Map<Integer, String> allStateByCountryId = null;
		try {
			allStateByCountryId = dservice.getAllStateByCountryId(countryId);
			logger.info(ALL_STATE_LOADED);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info(METHOD_EXECUTION_ENDED);
		return allStateByCountryId;

	}

	@GetMapping("/getCities")
	@ResponseBody
	public Map<Integer, String> getCitysByCountryId(@RequestParam("steId") Integer stateId) {
		logger.info(METHOD_EXECUTION_STATED);
		Map<Integer, String> allCityByStateId = null;
		try {
			allCityByStateId = dservice.getAllCityByStateId(stateId);
			logger.info(ALL_CITY_LOADED);
		} catch (Exception e) {
			e.getMessage();
		}
		logger.info(METHOD_EXECUTION_ENDED);
		return allCityByStateId;

	}

	@PostMapping(value = "/save")
	public String savedata(@ModelAttribute RegistrationForm form, RedirectAttributes attributes) {
		logger.debug(METHOD_EXECUTION_STATED);
		Boolean isSave = false;
		try {
			attributes.addFlashAttribute("registrationEntity", new RegistrationEntity());
			if (isSave) {
				mailUtils.sendUserAccUnlockMail2(form);
				attributes.addFlashAttribute("msg", "Registration almost done.Check your email to unlock account");
			} else {
				attributes.addFlashAttribute("msg", "RegistrationFaild");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.debug(METHOD_EXECUTION_ENDED);
		return "redirect:/reg/registration";

	}

	@GetMapping(value = "/mailValidate")
	@ResponseBody
	public String isMailExit(@RequestParam("email") String email) {
		logger.debug(METHOD_EXECUTION_STATED);
		String msg = "";
		try {
			Long count = service.emailValidate(email);
			if (count >= 1) {
				msg = email + " already Registerd";
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}

		logger.debug(METHOD_EXECUTION_ENDED);
		return msg;

	}

	@GetMapping(value = "/send")
	public void sendRedirect(@RequestParam("url") String url, HttpServletResponse res) throws IOException {

		logger.debug(METHOD_EXECUTION_STATED);
		res.sendRedirect(url);
		logger.debug(METHOD_EXECUTION_ENDED);

	}

}
