package com.softuni.webstore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

public abstract class BaseDao {
	public <T> T getSingleResult(TypedQuery<T> q) {
		List<T> lst;

		lst = q.getResultList();
		if (lst.size() == 0)
			return null;
		else
			return lst.get(0);
	}
}
