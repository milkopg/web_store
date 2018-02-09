package com.softuni.webstore.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.softuni.webstore.constants.Constants;
import com.softuni.webstore.entity.Currency;
import com.softuni.webstore.entity.Order;
import com.softuni.webstore.entity.OrderDetails;

public class OrderTest {
//	@Autowired
//	OrderService orderService;
	
	public OrderService getService() {
		return new OrderServiceImpl();
	}
	
	private List<OrderDetails> initDetailsListForTest() {
		List<OrderDetails> detailsList = new ArrayList<>();
		for (int i=1; i < 4; i++) {
			Currency currency = new Currency();
			currency.setRate(new BigDecimal(1));
			
			OrderDetails detail = new OrderDetails();
			detail.setCurrency(currency);
			detail.setQuantity(1*i);
			detail.setPrice(new BigDecimal(1000).multiply(new BigDecimal(i)));
			detailsList.add(detail);
		}
		return detailsList;
	}
	
	@Test
	public void testCalculateTotalPriceInOrderWithManyProducts() {
		Order order = new Order();
		order.setOrderDetails(initDetailsListForTest());
		Assert.assertEquals(new BigDecimal(14000), getService().calculateTotalPrice(order));
	}
	
	//@Test
	public void testCalculateRefundOrder()  {
		Order originalOrder = new Order();
		originalOrder.setOrderDetails(initDetailsListForTest());
		Order refundOrder = getService().generateRefundOrder(originalOrder);
		Assert.assertEquals(new BigDecimal(-14000), getService().calculateTotalPrice(refundOrder));
	}
	
	//@Test
	public void testRefundOrderType() {
		Order originalOrder = new Order();
		originalOrder.setOrderDetails(initDetailsListForTest());
		Order refundOrder = getService().generateRefundOrder(originalOrder);
		Assert.assertEquals(2, refundOrder.getOrderType().getId());
		Assert.assertEquals(Constants.ORDER_TYPE_REFUND, refundOrder.getOrderType().getName());
	}
}
