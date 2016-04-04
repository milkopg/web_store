package com.softuni.webstore.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.softuni.webstore.entity.Order;
import com.softuni.webstore.entity.OrderDetails;
import com.softuni.webstore.entity.Product;

public interface OrderDetailsService {
	public OrderDetails addProductToCart(Product product, Order order);
	public Order removeProductFromCart(Order order, int rowIndex);
	public OrderDetails getOrderDetailByProductId(long productId);
	public boolean decreaseProductQuantityAfterPurchasing(OrderDetails orderDetails);
	public List<String> validateChart();
}
