package com.hmei.hibernate.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="pro2_cart")
public class Cart {
	@Id
	@GeneratedValue
	private int id;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@MapKeyJoinColumn(name="product_id")
	@Column(name="quantity", columnDefinition="NUMBER")
	@CollectionTable(name="pro2_cart_items",
	joinColumns=@JoinColumn(name="cart_id"))
	private Map<Product, Integer> itemList;
	
	public Cart() {
		itemList = new LinkedHashMap<>();
	}
//Getter and Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map<Product, Integer> getItemList() {
		return itemList;
	}
	public void setItemList(Map<Product, Integer> itemList) {
		this.itemList = itemList;
	}

	
	
}
