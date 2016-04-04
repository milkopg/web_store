package com.softuni.webstore.dao;

import com.softuni.webstore.entity.ProductType;

public interface ProductTypeDao {
	public ProductType getProductTypeById(long id);
	public ProductType getProductTypeByName(String name);
}
