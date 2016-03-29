package com.softuni.webstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softuni.webstore.entity.Customer;

@Controller
public class UserController {
	@RequestMapping(value="registerUser", method = RequestMethod.POST)
	public String addToChart(Model model, @ModelAttribute("customer") Customer customer, HttpServletRequest request) {
		model.addAttribute(customer);
		return "home";
	}
}
