package com.softuni.webstore.service;

import java.util.List;

import com.softuni.webstore.entity.Product;

public interface ProductService {
	public boolean addProduct(Product product);
	public boolean editProduct(Product product);
	public boolean deleteProduct(long id);
	public boolean activateProduct(long id);
	public boolean deactivateProduct(long id);
	public List<Product> searchByCriteria(String criteria, String value);
	public Product getProductById(Long id);
	public List<Product> getAllProducts();
	public List<String> validateProduct(Product product);
}

