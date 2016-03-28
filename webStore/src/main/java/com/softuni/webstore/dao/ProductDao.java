package com.softuni.webstore.dao;

import java.util.List;

import com.softuni.webstore.entity.Product;

public interface ProductDao {
	public boolean addProduct(Product product);
	public boolean editProduct(Product product);
	public boolean deleteProduct(long id);
	public List<Product> searchByCriteria(String criteria, String value);
	public Product getProductById(Long id);
	public List<Product> getAllProducts();
}
