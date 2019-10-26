package com.onlinevotingsystem.ovs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.onlinevotingsystem.ovs.captcha.ICaptchaService;
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
	private UserService userService;
	  @Autowired
	  private ICaptchaService captchaService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.html
		return modelAndView;
	}
	@RequestMapping(value = { "/loginUser" }, method = RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		final String response = request.getParameter("g-recaptcha-response");
		String password= request.getParameter("password");
		if(response.equals("")) {
			modelMap.addAttribute("captchError", "Please confirm you are nota bot");
		     modelAndView.setViewName("register");
			 return modelAndView;
		}
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
	public ModelAndView registerUser(@Valid @ModelAttribute("crmUser")  CrmUser user, BindingResult bindingResult, ModelMap modelMap,	HttpServletRequest request ) {
		ModelAndView modelAndView =new ModelAndView();
		String userName = user.getUniqueId();
		String state= request.getParameter("state");
		//validationg captcha 
		
		final String response = request.getParameter("g-recaptcha-response");
		String password= request.getParameter("password");
		if(response.equals("")) {
			
			modelMap.addAttribute("captchError", "Please confirm you are not a bot");
		     modelAndView.setViewName("register");
			 return modelAndView;
		}
		
		if(state.equals("0")) {

			modelMap.addAttribute("stateError", "Please select your state");
		     modelAndView.setViewName("register");
			 return modelAndView;
			
		}
		
        captchaService.processResponse(response);

 //       LOGGER.debug("Registering user account with information: {}", accountDto);

   
		
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
