package com.softuni.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softuni.webstore.entity.Order;
import com.softuni.webstore.log4j.LoggerManager;

@Repository
public class OrderDaoImpl extends BaseDao implements OrderDao{

	Logger userlog = LoggerManager.getUserLogger();
	Logger systemlog = LoggerManager.getSystemLogger();

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	OrderTypeDao orderTypeDao;
	
	@Override
	public boolean addOrder(Order order) {
		try {
			em.persist(order);
			userlog.debug("Order was added successful: " + order);
			return true;
		} catch (Exception e) {
			userlog.error("Cannot add order: " + order);
			systemlog.error("Cannot add order: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean editOrder(Order order) {
		try {
			em.merge(order);
			userlog.debug("Order was edited successful: " + order);
			return true;
		} catch (Exception e) {
			userlog.error("Cannot edit order: " + order);
			systemlog.error("Cannot edit order: " + e.getMessage());
			return false;
		}
	}

	@Override
	public List<Order> searchOrderByCriteria(String criteria, String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
