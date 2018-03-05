package com.hmei.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import com.hmei.hibernate.model.CategoryConverter;
import com.hmei.spring.exceptionhandler.ProductConversionException;

@Entity
@Table(name = "pro2_product")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {
	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String name;

	@Lob
	private String description;

	@Column(nullable = false)
	private double price;

	@Column(nullable=false)
	private String image;


	@Column(nullable = false)
	@Range(min=0)
	private int amount;

	@Column(nullable = false)
	private String category;

	public Product() {
	}

	public Product(String name, String description, double price, int amount) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.amount = amount;
		this.category = this.getClass().getSimpleName();
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (amount != other.amount)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	public static Product convertObjectArrToProduct(Object[] o) throws ProductConversionException   {
		Class myclass= CategoryConverter.converterStringToProduct((String)o[2]);
		System.out.println(myclass.getName());
		Product p;
		try {
			System.out.println(myclass.newInstance().getClass());
			p = (Product) myclass.newInstance();
			System.out.println(1);
			p.setId((long)o[0]);
			p.setName((String)o[1]);
			p.setCategory((String)o[2]);
			p.setImage((String)o[3]);
			p.setPrice((double)o[4]);
		} catch (InstantiationException| IllegalAccessException e) {
			throw new ProductConversionException("Failed to map object array to Product");
		}
		
		return p;
	}

}
