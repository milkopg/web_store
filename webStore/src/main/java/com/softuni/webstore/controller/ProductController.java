package com.softuni.webstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softuni.webstore.entity.Product;
import com.softuni.webstore.log4j.LoggerManager;
import com.softuni.webstore.service.CurrencyService;
import com.softuni.webstore.service.ProductService;
import com.softuni.webstore.service.ProductTypeService;

@Controller
public class ProductController {
	Logger systemLogger = LoggerManager.getSystemLogger();
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CurrencyService currencyService;
	
	@Autowired
	ProductTypeService productTypeService;
	
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
		product.setTypes(productTypeService.getProductTypes());
		ModelAndView model = new ModelAndView("product", "product", product);
		return model;
	}
	
	@Transactional
	@RequestMapping(value="do_product", method = RequestMethod.POST)
	public ModelAndView doEditProduct(@ModelAttribute("product") @Valid Product product, @RequestParam ("id") long id,  @RequestParam ("currency.id") long currencyId,  @RequestParam ("type.id") long typeId, BindingResult result, HttpServletRequest request) {
		product.setCurrency(currencyService.getCurrencyById(currencyId));
		product.setType(productTypeService.getProductTypeById(typeId)); 
		if (id == 0)  {
			productService.addProduct(product);
		} else {
			productService.editProduct(product);
		}
		return new ModelAndView("product", "product", product);
	}
	
	@Transactional
	@RequestMapping(value="product_create", method = RequestMethod.GET)
	public ModelAndView createProduct(@ModelAttribute("product") @Valid Product product, BindingResult result, HttpServletRequest request) {
		product.setCurrency(currencyService.getCurrencyById(1l));
		product.setType(productTypeService.getProductTypeById(1));
		product.setTypes(productTypeService.getProductTypes());
		return new ModelAndView("product", "product", product);
	}
}
