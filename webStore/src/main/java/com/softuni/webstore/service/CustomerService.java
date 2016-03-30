package com.softuni.webstore.service;

import java.util.List;

import com.softuni.webstore.entity.Customer;
import com.softuni.webstore.entity.User;

public interface CustomerService {
	public boolean addCustomer(Customer customer);
	public boolean editCustomer (Customer customer);
	public Customer findCustomer (long id);
	public boolean activate (Customer customer);
	public boolean deactivateCustomer(Customer customer);
	public List<Customer> searchCustomerByCriteria(String criteria, String value);
	public List<String> validateCustomer(Customer customer);
	public List<String> validateUser(User user);
}
