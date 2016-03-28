package com.softuni.webstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softuni.webstore.entity.Product;
import com.softuni.webstore.log4j.LoggerManager;
import com.softuni.webstore.service.ProductService;

@Controller
public class ProductController {
	
	Logger systemLogger = LoggerManager.getSystemLogger();
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="home", method = RequestMethod.GET)
	public ModelAndView loadProducts() {
		List<Product> products = productService.getAllProducts();
		ModelAndView model = new ModelAndView("home", "products", products);
		return model;
	}
	
	@RequestMapping(value="product_details", method = RequestMethod.GET)
	public ModelAndView loadProductsDetails(HttpServletRequest request) {
		long id = 0;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (NumberFormatException nfe) {
			systemLogger.error("Cannot parse id: " + request.getParameter("id"));
		}
		return new ModelAndView("product_details", "product", productService.getProductById(id));
	}
	
	//@Transactional
	@RequestMapping(value="addToChart", method = RequestMethod.POST)
	public String addToChart(Model model, @ModelAttribute("product") Product product, HttpServletRequest request) {
		model.addAttribute(product);
		return "product_details";
	}
}
