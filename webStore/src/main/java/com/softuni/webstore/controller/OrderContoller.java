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
import com.softuni.webstore.log4j.LoggerManager;
import com.softuni.webstore.service.ProductService;

@Controller
public class OrderContoller extends BaseController{
	Logger systemLogger = LoggerManager.getSystemLogger();
	Logger userLogger = LoggerManager.getUserLogger();
	
	@Autowired
	ProductService productService;
	
	//@Transactional
	@RequestMapping(value="cart", method = RequestMethod.POST)
	public String addToChart(Model model, @ModelAttribute("order") Order order, HttpServletRequest request) {
		List<OrderDetails> details = new ArrayList<>();
		
		OrderDetails orderDetail = new OrderDetails();
		orderDetail.setProduct(productService.getProductById(Long.parseLong(request.getParameter("productId"))));
		details.add(orderDetail);
		order.setOrderDetails(details);
		
		model.addAttribute(order);
		return "cart";
	}
}
