package com.softuni.webstore.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.softuni.webstore.entity.OrderDetails;
import com.softuni.webstore.entity.Product;

public interface OrderDetailsService {
	public OrderDetails addProductToCart(Product product, HttpServletRequest request);
	public boolean removeProductFromCart(OrderDetails orderDetails, Product product);
	public List<String> validateChart();
}
