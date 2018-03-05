//package com.hmei.hibernate.entity;
//
//import java.util.Date;
//import java.util.Map;
//
//import javax.persistence.CollectionTable;
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.MapKeyJoinColumn;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//@Entity
//@Table(name="pro2_order")
//public class Order {
//	@Id
//	@GeneratedValue
//	private long id;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date orderDate;
//	private long orderNum;
//	
//	@ElementCollection
//	@MapKeyJoinColumn(name="product_id")
//	@CollectionTable(name="pro2_order_items",
//	joinColumns=@JoinColumn(name="order_id"))
//	@Column(name="quantity", columnDefinition="NUMBER")
//	private Map<Product, Integer> itemList;
//	
//	public Order() {}
//	public Order(Date orderDate, long orderNum) {
//		this.orderDate = orderDate;
//		this.orderNum = orderNum;
//	}
//	private double total;
//	
//	
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public Date getOrderDate() {
//		return orderDate;
//	}
//	public void setOrderDate(Date orderDate) {
//		this.orderDate = orderDate;
//	}
//	public long getOrderNum() {
//		return orderNum;
//	}
//	public void setOrderNum(long orderNum) {
//		this.orderNum = orderNum;
//	}
//
//	public Map<Product, Integer> getItemList() {
//		return itemList;
//	}
//	public void setItemList(Map<Product, Integer> itemList) {
//		this.itemList = itemList;
//	}
//	public double getTotal() {
//		return total;
//	}
//	public void setTotal(double total) {
//		this.total = total;
//	}
//
//	
//	
//}
