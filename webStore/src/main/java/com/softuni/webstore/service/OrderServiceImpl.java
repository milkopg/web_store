package com.softuni.webstore.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softuni.webstore.constants.Constants;
import com.softuni.webstore.dao.OrderDao;
import com.softuni.webstore.entity.Order;
import com.softuni.webstore.entity.OrderDetails;
import com.softuni.webstore.entity.OrderType;
import com.softuni.webstore.log4j.LoggerManager;

@Service
public class OrderServiceImpl implements OrderService{
	
	Logger systemlog = LoggerManager.getSystemLogger();

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderTypeService orderTypeService;

	@Override
	public boolean addOrder(Order order) {
		return orderDao.addOrder(order);
	}

	@Override
	public boolean editOrder(Order order) {
		return orderDao.editOrder(order);
	}

	@Override
	public Order createRefundOrder(Order originalOrder) {
		if (originalOrder == null) return null;
		
		Order refundOrder = new Order();
		refundOrder.setOrderDetails(originalOrder.getOrderDetails());
		
		for (OrderDetails detail : refundOrder.getOrderDetails()) {
			detail.setQuantity(detail.getQuantity() * -1);
		}
		
		
		refundOrder.setComment("Refund");
		refundOrder.setCustomer(originalOrder.getCustomer());
		refundOrder.setOrderType(getOrderTypeRefund());
		refundOrder.setPurchaseDate(Calendar.getInstance());
		refundOrder.setTotalPrice(calculateTotalPrice(refundOrder));
		return refundOrder;
	}
	
	private OrderType getOrderTypeRefund() {
		OrderType orderType = null;
		if (orderTypeService == null) {
			orderType = new OrderType();
			orderType.setId(2);
			orderType.setName(Constants.ORDER_TYPE_REFUND);
		} else {
			orderType = orderTypeService.getOrderTypeByName(Constants.ORDER_TYPE_REFUND);
		}
		return orderType;
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
	public List<Order> searchOrderByCriteria(String criteria, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> validateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
