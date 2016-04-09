package com.softuni.webstore.dao;

import com.softuni.webstore.entity.OrderDetails;

public interface OrderDetailsDao {
	public OrderDetails getOrderDetailsByProductId(long id);
}
