package com.softuni.webstore.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softuni.webstore.entity.Order;
import com.softuni.webstore.entity.OrderDetails;
import com.softuni.webstore.entity.Product;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Autowired
	ProductService productService;
	
	@Override
	public OrderDetails addProductToCart(Product product, Order order) {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setProduct(product);
		orderDetails.setPrice(product.getSinglePrice());
		orderDetails.setCurrency(product.getCurrency());
		orderDetails.setQuantity(1);
		orderDetails.setOrder(order);;
		return orderDetails;
	}

	@Override
	public Order removeProductFromCart(Order order, int rowIndex) {
		order.getOrderDetails().remove(rowIndex);
		return order;
	}

	@Override
	public List<String> validateChart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails getOrderDetailByProductId(long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean decreaseProductQuantityAfterPurchasing(OrderDetails orderDetails) {
		orderDetails.getProduct().setQuantity(orderDetails.getProduct().getQuantity() - 1);
		return true;//productService.editProduct(orderDetails.getProduct());
	}
}
