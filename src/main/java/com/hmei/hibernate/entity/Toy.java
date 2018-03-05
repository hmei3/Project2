package com.hmei.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pro2_toy")
public class Toy extends Product{
	
	@Column(nullable=false)
	private String company;
	
	public Toy() {}
	
	public Toy(String name, String description, double price, int amount) {
		super(name, description, price, amount);
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
}
