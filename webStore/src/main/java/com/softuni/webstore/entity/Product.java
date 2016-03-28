package com.softuni.webstore.entity;

import java.math.BigDecimal;

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

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

@Entity
@Table(name="t_product")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class Product {
	@Id
	@Column(name="id")
	@TableGenerator(name="TABLE_GEN_PRODUCT",table="T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "WEBSTORE.T_PRODUCT", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GEN_PRODUCT")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(optional=false, cascade={CascadeType.REFRESH})
	@JoinColumn(name="product_type_id")
	private ProductType type;
	
	@Column(name="single_price")
	private BigDecimal singlePrice;
	
	@Column(name="quantity")
	private int quantity;
	
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
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	
	public BigDecimal getSinglePrice() {
		return singlePrice;
	}
	public void setSinglePrice(BigDecimal singlePrice) {
		this.singlePrice = singlePrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "Product  id: " + getId() + ", name: " + getName() + ", product type: " + getType().getName() + 
				", single price: " + getSinglePrice() + ", quantity: " + getQuantity() + ", active: " + getActive();
	}
}
