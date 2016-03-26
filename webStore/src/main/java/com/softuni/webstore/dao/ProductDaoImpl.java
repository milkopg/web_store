package com.softuni.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.softuni.webstore.entity.Product;
import com.softuni.webstore.log4j.LoggerManager;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	Logger userlog = LoggerManager.getUserLogger();
	Logger systemlog = LoggerManager.getSystemLogger();
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> searchByCriteria(String criteria, String value) {
		TypedQuery<Product> q;
		
		q = em.createQuery("SELECT o FROM Account o."+ criteria + "LIKE o.+ %"+ value + "% ORDER BY o.id", Product.class);
		//q.setParameter("criteria", criteria);
		q.setParameter("value", "%" + value + "%");
		return q.getResultList();
	}

}
