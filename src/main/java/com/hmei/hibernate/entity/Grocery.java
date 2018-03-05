package com.hmei.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="pro2_grocery")
public class Grocery extends Product{
	
	private String ingredients;
	@Lob
	private String directions;
	
	public Grocery(String name, String description, double price, int amount) {
		super(name, description, price, amount);
		this.ingredients = "N/A";
		this.directions = "N/A";
	}
	
	public Grocery() {}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}
	
}
