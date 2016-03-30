package com.softuni.webstore.dao;

import java.util.List;

import com.softuni.webstore.entity.Customer;

public interface CustomerDao {
	public boolean addCustomer(Customer customer);
	public boolean editCustomer (Customer customer);
	public boolean activateCustomer (Customer customer);
	public boolean deactivateCustomer(Customer customer);
	public List<Customer> searchCustomerByCriteria(String criteria, String value);
}
