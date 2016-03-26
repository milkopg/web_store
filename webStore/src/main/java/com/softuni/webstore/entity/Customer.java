package com.softuni.webstore.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

@Entity
@Table(name="t_customer")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class Customer {
	@Id
	@Column(name="id")
	@TableGenerator(name="TABLE_GEN",table="T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "WEBSTORE.T_CUSTOMER", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GEN")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="birth_date")
	@Temporal(TemporalType.DATE)
	private Calendar birthDate;
	
	@Column(name="address")
	private String address;
	
	@ManyToOne(optional=false, cascade={CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="active")
	private int active;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Calendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
}
