package com.softuni.webstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softuni.webstore.entity.Product;
import com.softuni.webstore.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="home", method = RequestMethod.GET)
	public String loadProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		Product product = null;
		if (products != null && products.size() > 0) {
			product = products.get(0);
		}
		model.addAttribute("product", product);
		return "home";
	}
}
