package com.softuni.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softuni.webstore.dao.ProductDao;
import com.softuni.webstore.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Override
	public boolean addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public boolean editProduct(Product product) {
		return productDao.editProduct(product);
	}

	@Override
	public boolean deleteProduct(long id) {
		return productDao.deleteProduct(id);
	}

	@Override
	public List<Product> searchByCriteria(String criteria, String value) {
		return productDao.searchByCriteria(criteria, value);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
}
