package com.onlinevotingsystem.ovs.controller;

import javax.validation.Valid;

//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlinevotingsystem.ovs.model.User;
import com.onlinevotingsystem.ovs.service.UserService;
import com.onlinevotingsystem.ovs.user.CrmUser;


@Controller
public class AuthenticationController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.html
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		CrmUser user = new CrmUser();
		modelAndView.addObject("crmUser", user); 
		modelAndView.setViewName("register"); // resources/template/register.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home"); // resources/template/home.html
		return modelAndView;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("crmUser")  CrmUser user, BindingResult bindingResult, ModelMap modelMap ) {
		ModelAndView modelAndView =new ModelAndView();
		
		String userName = user.getUniqueId();
	//	logger.info("Processing registration form for: " + userName);
		
		// form validation
		 if (bindingResult.hasErrors()){
		///	 modelMap.set("register");
			 modelAndView.setViewName("register");
			 return modelAndView;
	        }

	
		
		if (userService.isUserAlreadyPresent(user)){
			modelMap.addAttribute("registrationError", "User name already exists.");
		     modelAndView.setViewName("register");
			 return modelAndView;
		 }
		 
	
			userService.saveUser(user);
	
			modelAndView.addObject("crmUser",new CrmUser());
			modelMap.addAttribute("message", "success");
		modelAndView.setViewName("register");
		return modelAndView;
		
		}
	}
