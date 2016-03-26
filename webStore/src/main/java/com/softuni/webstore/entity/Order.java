package com.softuni.webstore.entity;

import java.math.BigDecimal;
import java.util.Calendar;

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
@Table(name="t_order")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class Order {
	@Id
	@Column(name="id")
	@TableGenerator(name="TABLE_GEN",table="T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "WEBSTORE.T_ORDER", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GEN")
	private long id;
	
	@ManyToOne(optional=false, cascade={CascadeType.REFRESH})
	@JoinColumn(name="product_id")
	private Product product;
	
	
	@ManyToOne(optional=false, cascade={CascadeType.REFRESH})
	@JoinColumn(name="order_type_id")
	private OrderType orderType;
	
	@ManyToOne(optional=false, cascade={CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@Column(name="qty")
	private int qty;
	
	@Column(name="purchase_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Calendar purchaseDate;
	
	@Column(name="total_price")
	private BigDecimal totalPrice;
	
	@Column(name="comment")
	private String comment;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Calendar getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Calendar purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
