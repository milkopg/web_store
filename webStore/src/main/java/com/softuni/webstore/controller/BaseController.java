package com.softuni.webstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.softuni.webstore.entity.Order;

public abstract class BaseController {
	public HttpSession getSession() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true); // true == allow create
	}
	
	public Object getAttribute(String name, String defaultValue) {
		Object attribute = getSession().getAttribute(name);
		return (attribute != null) ? attribute : defaultValue ;  
	}
	
	
	public void setAttribute(String name, Object value) {
		getSession().setAttribute(name, value);
	}
	
	public Order getOrder() {
		return (Order) getSession().getAttribute("order");
	}
}
