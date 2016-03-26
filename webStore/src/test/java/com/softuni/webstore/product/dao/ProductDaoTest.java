package com.softuni.webstore.product.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softuni.webstore.dao.ProductDaoImpl;
//@Repository
public class ProductDaoTest {
//	@PersistenceContext
//	private EntityManager em;
	
	//@Autowired
	ProductDaoImpl productDao = new ProductDaoImpl();
	
	
	
	@Test
	public void testSearchProductByCriteria() {
		String criteria = "name";
		String value = "dell";
//		Assert.assertNotNull(productDao.searchByCriteria(criteria, value));
	}
}
