package com.softuni.webstore.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.softuni.webstore.entity.OrderDetails;
import com.softuni.webstore.entity.Product;

@Service
@Scope("session")
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Override
	public boolean addProductToOrderDetails(OrderDetails orderDetails, Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeProductFromOrderDetails(OrderDetails orderDetails, Product product) {
		// TODO Auto-generated method stub
		return false;
	}
}
