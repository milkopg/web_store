package com.softuni.webstore.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softuni.webstore.constants.Constants;
import com.softuni.webstore.entity.Customer;
import com.softuni.webstore.entity.Order;
import com.softuni.webstore.entity.OrderDetails;
import com.softuni.webstore.log4j.LoggerManager;
import com.softuni.webstore.service.CustomerService;
import com.softuni.webstore.service.OrderDetailsService;
import com.softuni.webstore.service.OrderService;
import com.softuni.webstore.service.OrderTypeService;
import com.softuni.webstore.service.ProductService;
import com.softuni.webstore.utility.UserUtils;

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
	
	@Autowired
	CustomerService customerService;
	
	//@Transactional
	//@ModelAttribute("order") Order order,
	@RequestMapping(value="addToCart", method = RequestMethod.POST)
	public ModelAndView addToCart(Model model,  @RequestParam long productId, HttpServletRequest request) {
		Order order = getOrder();
		if (order == null) {
			order = new Order();
			getSession().setAttribute("order", order);
		} 
		order.getOrderDetails().add(orderDetailsService.addProductToCart(productService.getProductById(productId), order));
		order.setTotalPrice(orderService.calculateTotalPrice(order));
		order.setTotalQuantity(orderService.calculateTotalQuantity(order));
		model.addAttribute(order);
		getSession().setAttribute("order", order);
		return new ModelAndView("cart", "order", order) ;
	}
	
	
	@RequestMapping(value="cart", method=RequestMethod.GET)
	public ModelAndView showCart (Model model, HttpServletRequest request) {
		return new ModelAndView("cart", "order", getOrder());
	}
	
	@Transactional  
	@RequestMapping(value="processOrder", method=RequestMethod.POST)
	public String processOrder(HttpServletRequest request) {
		Order order = getOrder();
		if (order == null) return "login";
		order.setComment(request.getParameter("order.comment"));
		
		//if user is not logged/ it will be replaced with security if
		Customer customer = customerService.getCustomerByUsername(UserUtils.getUser().getUsername());
		if (customer == null) return "login";
		else {
			order.setCustomer(customer);
		}
//		if (order.getCustomer() == null) {
//			return "login";
//		}
		fillOrderDetails(order, request);
		if (orderService.addOrder(order)) {
			getSession().removeAttribute("session");
			
			for (OrderDetails orderDetail: order.getOrderDetails()) {
				orderDetailsService.decreaseProductQuantityAfterPurchasing(orderDetail);
			}
			return "order_success";
		} else {
			return "cart";
		}
	}
	
	@RequestMapping(value="deleteProductFromCart", method=RequestMethod.GET)
	public String removeProductFromCart(@RequestParam int rowIndex) {
		Order order = getOrder();
		order.getOrderDetails().remove(rowIndex);
		return "cart";
	}	

	private void fillOrderDetails(Order order, HttpServletRequest request) {
		order.setOrderType(orderTypeService.getOrderTypeByName(Constants.ORDER_TYPE_SELL));
		order.setPurchaseDate(new Date());
	}
}
