package com.softuni.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softuni.webstore.dao.CustomerDao;
import com.softuni.webstore.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public boolean addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public boolean editCustomer(Customer customer) {
		return customerDao.editCustomer(customer);
	}

	@Override
	public boolean activate(Customer customer) {
		customer.setActive(true);
		return customerDao.activateCustomer(customer);
	}

	@Override
	public boolean deactivateCustomer(Customer customer) {
		customer.setActive(false);
		return customerDao.deactivateCustomer(customer);
	}

	@Override
	public List<Customer> searchCustomerByCriteria(String criteria, String value) {
		return customerDao.searchCustomerByCriteria(criteria, value);
	}

	@Override
	public List<String> validateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
  