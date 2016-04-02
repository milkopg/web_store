package com.softuni.webstore.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softuni.webstore.constants.Constants;
import com.softuni.webstore.entity.Order;
import com.softuni.webstore.entity.Product;
import com.softuni.webstore.log4j.LoggerManager;
import com.softuni.webstore.service.OrderDetailsService;
import com.softuni.webstore.service.OrderService;
import com.softuni.webstore.service.OrderTypeService;
import com.softuni.webstore.service.ProductService;

@Controller
public class OrderContoller extends BaseController{
	Logger systemLogger = LoggerManager.getSystemLogger();
	Logger userLogger = LoggerManager.getUserLogger();
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderTypeService orderTypeService;
	
	//@Transactional
	//@ModelAttribute("order") Order order,
	@RequestMapping(value="cart", method = RequestMethod.POST)
	public ModelAndView addToCart(Model model,  @RequestParam long productId, HttpServletRequest request) {
		Order order = (Order) request.getSession().getAttribute("order");
		if (order == null) {
			order = new Order();
			getSession().setAttribute("order", order);
		} 
		order.getOrderDetails().add(orderDetailsService.addProductToCart(productService.getProductById(productId), request));
		order.setTotalPrice(orderService.calculateTotalPrice(order));
		order.setTotalQuantity(orderService.calculateTotalQuantity(order));
		model.addAttribute(order);
		getSession().setAttribute("order", order);
		return new ModelAndView("cart", "order", order) ;
	}
	
//	@RequestMapping(value="removeProduct/*", method=RequestMethod.POST)
//	public String cartDeleteProduct(Model model, @ModelAttribute ("order") Order order, HttpServletRequest request) {
//		String path = request.getServletPath();
//		String [] folders = path.split("/");
//		Product product = productService.getProductById(Long.parseLong(folders[folders.length-1]));
//		//orderDetailsService.removeProductFromCart(order, rowIndex);
//		return "cart";
//	}
	
	@Transactional  
	@RequestMapping(value="processOrder", method=RequestMethod.POST)
	public String processOrder(HttpServletRequest request) {
		Order order = (Order) request.getSession().getAttribute("order");
		if (order.getCustomer() == null) {
			return "login";
		}
		fillOrderDetails(order);
		if (orderService.addOrder(order)) {
			getSession().removeAttribute("session");
			return "order_success";
		} else {
			return "processOrder";
		}
	}

	private void fillOrderDetails(Order order) {
		if (order == null) return;
		order.setOrderType(orderTypeService.getOrderTypeByName(Constants.ORDER_TYPE_SELL));
		order.setPurchaseDate(new Date());
	}
}
