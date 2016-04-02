package com.softuni.webstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softuni.webstore.constants.Constants;
import com.softuni.webstore.dao.CustomerDao;
import com.softuni.webstore.entity.Customer;
import com.softuni.webstore.entity.Role;
import com.softuni.webstore.entity.User;

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
	public Customer findCustomer(long id) {
		return customerDao.findCustomer(id);
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
		List<String> errors = new ArrayList<>();
		if (customer == null) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "Customer"));
		//if (customer.getBirthDate() == null) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "Birth Date"));
		if (customer.getName() == null) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "Name"));
		if (customer.getUser() == null) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "User"));
		
		errors.addAll(validateUser(customer.getUser()));
		
		return errors;
	}

	@Override
	public List<String> validateUser(User user) {
		List<String> errors = new ArrayList<>();
		if (user.getUsername() == null) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "Username"));
		if (user.getPassword() == null) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "User Password"));
		if (user.getRole() == null) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "User Role"));
		
		return errors;
	}

	@Override
	public boolean addRole(Customer customer, Role role) {
		customer.getUser().setRole(role);
		return true;
	}
}
  