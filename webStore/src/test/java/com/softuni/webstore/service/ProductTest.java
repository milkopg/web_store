package com.softuni.webstore.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.softuni.webstore.entity.Product;
import com.softuni.webstore.service.ProductService;

public class ProductTest {
	Map <Long, Product> products = new HashMap<>();
	ProductService service = new MockProductService(products);
	
	@Test
	public void testCreateTwoEmptyProducts() {
		Product product = new Product();
		Assert.assertEquals(true, service.addProduct(product));
		Product product2 = new Product();
		Assert.assertEquals(true, service.addProduct(product2));
	}
	
	@Test 
	public void testEditEmptyProduct() {
		Product product = new Product();
		Assert.assertEquals(true, service.editProduct(product));
	}
	
	@Test
	public void testDeleteProduct() {
		Product product = new Product();
		service.addProduct(product);
		Assert.assertEquals(true, service.deleteProduct(product.getId()));
	}
	
	@Test
	public void testSeachProductBySpecificField() {
		Assert.assertEquals(null, service.searchByCriteria(null, null));
	}
}
