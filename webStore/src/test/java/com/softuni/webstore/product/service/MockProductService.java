package com.softuni.webstore.product.service;

import java.util.List;
import java.util.Map;

import com.softuni.webstore.entity.Product;
import com.softuni.webstore.service.ProductService;

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
	
	
}
