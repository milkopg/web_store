package com.softuni.webstore.service;

import java.util.List;
import java.util.Map;

import com.softuni.webstore.entity.Product;

public class MockProductService implements ProductService{
	private Map<Long, Product> products;
	public MockProductService(Map<Long,Product> products) {
		this.products = products;
	}
	@Override
	public boolean addProduct(Product product) {
		try {
			products.put(product.getId(), product);
			return true;
		} catch (Exception e)  {
			return false;
		}
	}
	@Override
	public boolean editProduct(Product product) {
		try {
			products.replace(product.getId(), product);
			return true;
		} catch (Exception e)  {
			return false;
		}
	}
	@Override
	public boolean deleteProduct(long id) {
		try {
			products.remove(id);
			return true;
		} catch (Exception e)  {
			return false;
		}
	}
	@Override
	public List<Product> searchByCriteria(String criteria, String value) {
		if (criteria == null  || value == null) return null;
		return null;
	}
	
	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<String> validateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean activateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deactivateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
