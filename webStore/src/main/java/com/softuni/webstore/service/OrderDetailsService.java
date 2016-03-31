package com.softuni.webstore.service;

import com.softuni.webstore.entity.OrderDetails;
import com.softuni.webstore.entity.Product;

public interface OrderDetailsService {
	public boolean addProductToOrderDetails(OrderDetails orderDetails, Product product);
	public boolean removeProductFromOrderDetails(OrderDetails orderDetails, Product product);
}
