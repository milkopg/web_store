package com.softuni.webstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softuni.webstore.constants.Constants;
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

	@Override
	public Product getProductById(Long id) {
		return productDao.getProductById(id);
	}

	@Override
	public boolean activateProduct(Product product) {
		product.setActive(Boolean.TRUE);
		return productDao.activateProduct(product);
	}

	@Override
	public boolean deactivateProduct(Product product) {
		product.setActive(Boolean.FALSE);
		return productDao.deactivateProduct(product);
	}

	@Override
	public List<String> validateProduct(Product product) {
		List<String> errors = new ArrayList<>();
		if (product == null) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "Product"));
		if ((product.getCurrency() == null)  || (product.getCurrency().getRate() == null)) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "Currency"));
		if (product.getName() == null) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "Name"));
		if (product.getQuantity() == 0) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "Quantity"));
		if (product.getSinglePrice() == null) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "Price"));
		if (product.getType() == null) errors.add(Constants.ERROR_MANDATORY.replace("{0}", "Type"));
		return errors;
	}
}
