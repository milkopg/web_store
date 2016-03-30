package com.softuni.webstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.softuni.webstore.entity.OrderType;
import com.softuni.webstore.log4j.LoggerManager;

@Repository
public class OrderTypeDaoImpl extends BaseDao implements OrderTypeDao{
	Logger userlog = LoggerManager.getUserLogger();
	Logger systemlog = LoggerManager.getSystemLogger();

	@PersistenceContext
	private EntityManager em;

	@Override
	public OrderType getOrderTypeById(long id) {
		OrderType orderType = null;
		try {
			orderType = em.find(OrderType.class, id);
			userlog.debug("OrderType was found in database: " + orderType);
			return orderType;
		} catch (Exception e) {
			userlog.error("Cannot find OrderType: " + orderType);
			systemlog.error("Cannot find OrderType: " + e.getMessage());
			return null;
		}
	}

	@Override
	public OrderType getOrderTypeByName(String name) {
		TypedQuery<OrderType> q;
		
		q = em.createQuery("SELECT o FROM OrderType o WHERE o.name = :name ORDER BY o.id", OrderType.class);
		q.setParameter("name", name);
		return getSingleResult(q);
	}
}
