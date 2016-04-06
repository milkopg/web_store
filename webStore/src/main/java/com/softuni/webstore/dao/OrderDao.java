package com.softuni.webstore.dao;

import java.util.List;

import com.softuni.webstore.entity.Order;

public interface OrderDao {
	public boolean addOrder(Order order);
	public boolean editOrder(Order order);
	public Order getOrderById(long id);
	public List<Order> searchOrderByCriteria(String criteria, String value);
	public List<Order> getOrders();
}
