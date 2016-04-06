package com.softuni.webstore.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softuni.webstore.constants.Constants;
import com.softuni.webstore.entity.Customer;
import com.softuni.webstore.entity.Order;
import com.softuni.webstore.entity.OrderDetails;
import com.softuni.webstore.entity.Product;
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
	
	@Autowired
	MessageSource message;
	
	//@Transactional
	//@ModelAttribute("order") Order order,
	@RequestMapping(value="addToCart", method = RequestMethod.POST)
	public ModelAndView addToCart(Model model,  @RequestParam long productId, HttpServletRequest request) {
		Order order = getOrder();
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
		
		Customer customer = customerService.getCustomerByUsername(UserUtils.getUser().getUsername());

		if (customer == null) return "login";
		else {
			order.setCustomer(customer);
		}
		
		fillOrderDetails(order, request);
		
		for (OrderDetails orderDetail: order.getOrderDetails()) {
			orderDetailsService.decreaseProductQuantityAfterPurchasing(orderDetail);
		}
		
		if (orderService.addOrder(order)) {
			getSession().removeAttribute("session");
			getSession().invalidate();
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
	
	@RequestMapping(value="order_table", method=RequestMethod.GET)
	public ModelAndView showOrderTable (Model model, HttpServletRequest request) {
		return new ModelAndView("order_table", "orders", orderService.getOrders());
	}
	
	@Transactional
	@RequestMapping(value="order_refund", method=RequestMethod.GET)
	public ModelAndView refundOrder (final RedirectAttributes redirectAttributes,  @RequestParam ("id") long id) {
		Order originalOrder = orderService.getOrderById(id);
		List<Order> orders = orderService.getOrders();
		if (!Constants.ORDER_TYPE_SELL.equals(originalOrder.getOrderType().getName())) {
			//result.addError(new ObjectError("orders",  "Ko staa e feis"/*message.getMessage(code, args, getLocale())*/ ));
			//errors.rejectValue("*", "order.refund.success", "Ko staa e feis") ;
			redirectAttributes.addAttribute("msg", "Ko staa e feis");
			//ValidationUtils.rejectIfEmpty(result.getE, "*", "order.refund.success");
			
			//result.getGlobalErrors().add(new ObjectError("orders",  "Ko staa e feis"/*message.getMessage(code, args, getLocale())*/ ))
			//result.getGlobalErrors().add(new ObjectError("orders", message.getMessage(order.refund.success, null, getLocale())));
			//ValidationUtils.rejectIfEmptyOrWhitespace(result.getGlobalErrors(), "*", "order.refund.success");
			return new ModelAndView("order_table", "orders", orders);
		} 
		
		originalOrder.setOrderType(orderTypeService.getOrderTypeByName(Constants.ORDER_TYPE_REFUNDED));
		
		orderService.addOrder(orderService.generateRefundOrder(originalOrder));
		orderService.editOrder(originalOrder);
		
		
		return new ModelAndView("order_table", "orders", orders);
	}
}
