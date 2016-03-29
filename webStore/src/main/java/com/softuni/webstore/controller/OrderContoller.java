package com.softuni.webstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softuni.webstore.entity.Order;
import com.softuni.webstore.log4j.LoggerManager;

@Controller
public class OrderContoller extends BaseController{
	Logger systemLogger = LoggerManager.getSystemLogger();
	Logger userLogger = LoggerManager.getUserLogger();
	
	
	//@Transactional
	@RequestMapping(value="cart", method = RequestMethod.POST)
	public String addToChart(Model model, @ModelAttribute("order") Order order, HttpServletRequest request) {
		model.addAttribute(order);
		return "cart";
	}
}
