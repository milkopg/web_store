package com.softuni.webstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softuni.webstore.entity.Customer;
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
	public ModelAndView loadProductsDetails(@RequestParam long id) {
		return new ModelAndView("product_details", "product", productService.getProductById(id));
	}
	
	@RequestMapping(value="performProductSearch", method=RequestMethod.GET)
	public ModelAndView performProductSearch(HttpServletRequest request) {
		String criteria = request.getParameter("criteriaGroup");
		String value = request.getParameter("criteriaValue");
		String operation = request.getParameter("operation");
		if (value == null) value = "";
		return new ModelAndView("home", "products", productService.searchByCriteria(criteria, value, operation));
	}
	
	@RequestMapping(value="product_table", method = RequestMethod.GET)
	public ModelAndView product_table() {
		List<Product> products = productService.getAllProducts();
		ModelAndView model = new ModelAndView("product_table", "products", products);
		return model;
	}
	
	@RequestMapping(value="product_edit", method = RequestMethod.GET)
	public ModelAndView editProducts(@RequestParam long id) {
		Product product = productService.getProductById(id);
		ModelAndView model = new ModelAndView("product_edit", "product", product);
		return model;
	}
	
	@RequestMapping(value="do_product_edit", method = RequestMethod.POST)
	public ModelAndView doEditProduct(@ModelAttribute("product") @Valid Product product, BindingResult result,  HttpServletRequest request) {
		productService.editProduct(product);
		return new ModelAndView("product_edit", "product", product);
	}
}
