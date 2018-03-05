//package com.hmei.hibernate.entity;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="pro2_payment")
//public class Payment {
//	@Id
//	@GeneratedValue
//	private int id;
//	private String holder;
//	private long cardNumber;
//	private String expirationDate;
//	
//	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//			CascadeType.DETACH, CascadeType.REFRESH})
//	private Address billingAddress;
//	
//	public Payment() {}
//	public Payment(String holder,
//			long cardNumber,
//			String expirationDate,
//			Address billingAddress) {
//		this.holder = holder;
//		this.cardNumber = cardNumber;
//		this.expirationDate = expirationDate;
//		this.billingAddress = billingAddress;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getHolder() {
//		return holder;
//	}
//
//	public void setHolder(String holder) {
//		this.holder = holder;
//	}
//
//	public long getCardNumber() {
//		return cardNumber;
//	}
//
//	public void setCardNumber(long cardNumber) {
//		this.cardNumber = cardNumber;
//	}
//
//	public String getExpirationDate() {
//		return expirationDate;
//	}
//
//	public void setExpirationDate(String expirationDate) {
//		this.expirationDate = expirationDate;
//	}
//
//	public Address getBillingAddress() {
//		return billingAddress;
//	}
//
//	public void setBillingAddress(Address billingAddress) {
//		this.billingAddress = billingAddress;
//	}	
//	
//}
