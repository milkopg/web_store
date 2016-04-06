package com.softuni.webstore.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softuni.webstore.constants.Constants;
import com.softuni.webstore.dao.OrderDao;
import com.softuni.webstore.dao.OrderTypeDao;
import com.softuni.webstore.entity.Order;
import com.softuni.webstore.entity.OrderDetails;
import com.softuni.webstore.entity.OrderType;
import com.softuni.webstore.log4j.LoggerManager;
import com.softuni.webstore.utility.UserUtils;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderTypeDao orderTypeDao;
	
	Logger systemlog = LoggerManager.getSystemLogger();

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderTypeService orderTypeService;
	
	@Autowired
	CustomerService customerService;
	

	@Override
	public boolean addOrder(Order order) {
		return orderDao.addOrder(order);
	}

	@Override
	public boolean editOrder(Order order) {
		return orderDao.editOrder(order);
	}
	
	@Override
	public Order getOrderById(long id) {
		return orderDao.getOrderById(id);
	}

	@Override
	public Order generateRefundOrder(Order originalOrder) {
		if (originalOrder == null) return null;
		
		Order refundOrder = new Order();
		
		refundOrder.setCustomer(originalOrder.getCustomer());
		refundOrder.setComment("Refund id: " + originalOrder.getId() + ", done by user:" + customerService.getCustomerByUsername(UserUtils.getUser().getUsername()).getName());
		refundOrder.setOrderType(orderTypeService.getOrderTypeByName(Constants.ORDER_TYPE_REFUND));
		refundOrder.setPurchaseDate(new Date());
		refundOrder.setTotalPrice(originalOrder.getTotalPrice());
		refundOrder.setTotalQuantity(originalOrder.getTotalQuantity() * -1);
		refundOrder.setOrderDetails(generateRefundOrderDetails(originalOrder, refundOrder));
		
//		editOrder(originalOrder);
//		addOrder(refundOrder);
		return refundOrder;
	}
	
	@Override
	public List<OrderDetails> generateRefundOrderDetails(Order originalOrder, Order refundOrder) {
		List<OrderDetails> details = new ArrayList<>();
		for (OrderDetails originalDetail : originalOrder.getOrderDetails()) {
			OrderDetails detail = new OrderDetails();
			detail.setCurrency(originalDetail.getCurrency());
			detail.setPrice(originalDetail.getPrice());
			detail.setProduct(originalDetail.getProduct());
			detail.setQuantity(originalDetail.getQuantity()*-1);
			detail.setOrder(refundOrder);
			details.add(detail);
		}
		return details;
	}

	
	@Override
	public BigDecimal calculateTotalPrice(Order order) {
		if (order == null) return null;
		BigDecimal totalPrice = new BigDecimal(0);
		for (OrderDetails detail : order.getOrderDetails()) {
			try {
				totalPrice = totalPrice.add( detail.getPrice().multiply(new BigDecimal(detail.getQuantity())).multiply(detail.getCurrency().getRate()) );
			} catch (Exception e) {
				systemlog.error("calculateTotalPrice: cannot calculatePrice" + order);
			}
		}
		return totalPrice;
	}
	
	@Override
	public int calculateTotalQuantity(Order order) {
		if (order == null) return 0;
		int totalQuantity = 0;
		for (OrderDetails detail : order.getOrderDetails()) {
			try {
				totalQuantity += detail.getQuantity();
			} catch (Exception e) {
				systemlog.error("calculateTotalQuantity: cannot calculate quantity" + order);
			}
		}
		return totalQuantity;
	}

	@Override
	public List<Order> searchOrderByCriteria(String criteria, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> validateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrders() {
		return orderDao.getOrders();
	}



}
