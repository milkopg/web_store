package com.softuni.webstore.service;

import java.math.BigDecimal;
import java.util.List;

import com.softuni.webstore.entity.Order;

public interface OrderService {
	public boolean addOrder(Order order);
	public boolean editOrder(Order order);
	public Order createRefundOrder(Order originalOrder);
	public BigDecimal calculateTotalPrice(Order order);
	public List<Order> searchOrderByCriteria(String criteria, String value);
	public List<String> validateOrder(Order order);
}
