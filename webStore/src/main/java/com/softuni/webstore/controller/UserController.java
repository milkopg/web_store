package com.softuni.webstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softuni.webstore.constants.Constants;
import com.softuni.webstore.entity.Customer;
import com.softuni.webstore.log4j.LoggerManager;
import com.softuni.webstore.security.MD5;
import com.softuni.webstore.service.CustomerService;
import com.softuni.webstore.service.RoleService;
import com.softuni.webstore.utility.UserUtils;

@Controller
public class UserController extends BaseController{
	Logger userLogger = LoggerManager.getUserLogger();
	Logger systemLogger = LoggerManager.getSystemLogger();
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	MessageSource message;
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="register", method = RequestMethod.GET)
	public ModelAndView register(@ModelAttribute("customer") Customer customer) {
		return new ModelAndView("register", "customer", customer);
	}
	
	@Transactional
	@RequestMapping(value="doRegister", method = RequestMethod.POST)
	public ModelAndView doRegister(@Valid @ModelAttribute ("customer") Customer customer, BindingResult result,  @RequestParam ("id") long id,  HttpServletRequest request) {
		customerService.addRole(customer, roleService.getRoleByName(Constants.ROLE_USER));
		
		if (!result.hasErrors()) {
			if (customer.getUser().getUsername() == null || "".equals(customer.getUser().getUsername())) return new ModelAndView("register").addObject("msg", message.getMessage("account.error.empty.username", null, getLocale()));
			if (!customer.getUser().getPassword().equals(customer.getUser().getRetypePassword())) return new ModelAndView("register").addObject("msg", message.getMessage("account.error.password", null, getLocale())); 
				
			if (id == 0)  {
				customer.getUser().setPassword(MD5.crypt(customer.getUser().getPassword()));
				customerService.addCustomer(customer);
				customerService.activate(customer);
			} else  {
				customer.getUser().setPassword(MD5.crypt(customer.getUser().getPassword()));
				customerService.editCustomer(customer);
			}
			return new ModelAndView("register", "customer", new Customer()).addObject("msg", message.getMessage("account.register.success", null, getLocale()));
		} else {
			return new ModelAndView("register");
		}
	}
	
	@RequestMapping(value="account_table", method = RequestMethod.GET)
	public ModelAndView customer_table() {
		List<Customer> accounts = customerService.getAllCustomers();
		ModelAndView model = new ModelAndView("account_table", "accounts", accounts);
		return model;
	}
	
	@RequestMapping(value="account_edit", method = RequestMethod.GET)
	public ModelAndView accountsEdit(@RequestParam long id) {
		Customer customer = customerService.getCustomerById(id);
		ModelAndView model = new ModelAndView("register", "customer", customer);
		return model;
	}
	
	@RequestMapping(value="account", method = RequestMethod.GET)
	public ModelAndView accountEdit() {
		Customer customer = customerService.getCustomerByUsername(UserUtils.getUser().getUsername());;
		return new ModelAndView("register", "customer", customer);
	}
}
