package com.hmei.hibernate.model;

import com.hmei.hibernate.entity.Book;
import com.hmei.hibernate.entity.Computer;
import com.hmei.hibernate.entity.Grocery;
import com.hmei.hibernate.entity.Product;
import com.hmei.hibernate.entity.Toy;

public class CategoryConverter {
	public static Class converterStringToProduct(String category) {
		if (category.equals("Book")) {
			return Book.class;
		} else if (category.equals("Computer")) {
			return Computer.class;
		} else if (category.equals("Toy")) {
			return Toy.class;
		} else if (category.equals("Grocery")) {
			return Grocery.class;
		} else {
			return Product.class;
		}
	}
}
