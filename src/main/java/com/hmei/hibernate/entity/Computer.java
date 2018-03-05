package com.hmei.hibernate.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="pro2_computer")
public class Computer extends Product{

	@Embedded
	private Specification specification;
	
	public Computer() {}
	public Computer(String name, String description, double price, int amount) {
		super(name, description, price, amount);
		this.specification = new Specification();
		
	}

	public Specification getSpecification() {
		return specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}
}
