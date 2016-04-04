package com.softuni.webstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softuni.webstore.dao.ProductTypeDao;
import com.softuni.webstore.entity.ProductType;

@Service
public class ProductTypeServiceImpl implements ProductTypeService{
	
	@Autowired
	ProductTypeDao productTypeDao;

	@Override
	public ProductType getProductTypeById(long id) {
		return productTypeDao.getProductTypeById(id);
	}

	@Override
	public ProductType getProductTypeByName(String name) {
		return productTypeDao.getProductTypeByName(name);
	}
}
