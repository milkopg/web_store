package com.softuni.webstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softuni.webstore.entity.Order;
import com.softuni.webstore.entity.OrderDetails;
import com.softuni.webstore.entity.Product;
import com.softuni.webstore.log4j.LoggerManager;
import com.softuni.webstore.service.OrderDetailsService;
import com.softuni.webstore.service.ProductService;

@Controller
public class OrderContoller extends BaseController{
	Logger systemLogger = LoggerManager.getSystemLogger();
	Logger userLogger = LoggerManager.getUserLogger();
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderDetailsService orderDetailsService;
	
	//@Transactional
	//@ModelAttribute("order") Order order,
	@RequestMapping(value="cart", method = RequestMethod.POST)
	public String addToCart(Model model,  @ModelAttribute("products") Product product, HttpServletRequest request) {
		Order order = (Order) getSession().getAttribute("order");
		Long productId = Long.parseLong(request.getParameter("productId")); 
		if (order == null) {
			order = new Order();
			getSession().setAttribute("order", order);
		} 
		//OrderDetails orderDetails = orderDetailsService.addProductToCart(productService.getProductById(Long.parseLong(request.getParameter("productId"))));
		order.getOrderDetails().add(orderDetailsService.addProductToCart(productService.getProductById(productId), request));
		//orderDetail.setProduct(productService.getProductById(Long.parseLong(request.getParameter("productId"))));
		
		model.addAttribute(order);
		return "cart";
	}
}
