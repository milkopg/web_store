package com.softuni.webstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softuni.webstore.constants.Constants;
import com.softuni.webstore.entity.Customer;
import com.softuni.webstore.log4j.LoggerManager;
import com.softuni.webstore.service.CustomerService;
import com.softuni.webstore.service.RoleService;

@Controller
public class UserController extends BaseController{
	Logger userLogger = LoggerManager.getUserLogger();
	Logger systemLogger = LoggerManager.getSystemLogger();
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="register", method = RequestMethod.GET)
	public String register() {
		//model.addAttribute("customer", new Customer());
		//return new ModelAndView("register", "customer", model);
		return "register";
	}
	
	@Transactional
	@RequestMapping(value="doRegister", method = RequestMethod.POST)
	public String doRegister(Model model, @ModelAttribute("customer") Customer customer, HttpServletRequest request) {
		customerService.addRole(customer, roleService.getRoleByName(Constants.ROLE_USER));
		if (customerService.validateCustomer(customer).size()  == 0) {
			customerService.addCustomer(customer);
			//model.addAttribute("customer", customer);
			return "register_success";
			//return new ModelAndView("register_success", "customer", customer);
		} else {
			return null;
		}
		
		//return new ModelAndView("register_success", "customer", customer);
	}
}
