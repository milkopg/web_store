package com.softuni.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.softuni.webstore.entity.Customer;
import com.softuni.webstore.log4j.LoggerManager;

@Repository
public class CustomerDaoImp extends BaseDao implements CustomerDao {
	Logger userlog = LoggerManager.getUserLogger();
	Logger systemlog = LoggerManager.getSystemLogger();

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean addCustomer(Customer customer) {
		try {
			em.persist(customer);
			userlog.debug("Customer was added successful: " + customer);
			return true;
		} catch (Exception e) {
			userlog.error("Cannot add customer: " + customer);
			systemlog.error("Cannot add customer: " + e.getMessage());
			return false;
		}

	}

	@Override
	public boolean editCustomer(Customer customer) {
		try {
			em.merge(customer);
			userlog.debug("customer was edited successful: " + customer);
			return true;
		} catch (Exception e) {
			userlog.error("Cannot edit customer: " + customer);
			systemlog.error("Cannot edit customer: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean activateCustomer(Customer customer) {
		try {
			em.merge(customer);
			userlog.debug("Customer was activated successful: " + customer);
			return true;
		} catch (Exception e) {
			userlog.error("Cannot activate customer: " + customer);
			systemlog.error("Cannot activate customer: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deactivateCustomer(Customer customer) {
		try {
			em.merge(customer);
			userlog.debug("Customer was deactivated successful: " + customer);
			return true;
		} catch (Exception e) {
			userlog.error("Cannot deactivate customer: " + customer);
			systemlog.error("Cannot deactivate customer: " + e.getMessage());
			return false;
		}
	}

	@Override
	public List<Customer> searchCustomerByCriteria(String criteria, String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
