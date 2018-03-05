package com.hmei.spring.service;

import java.util.Set;

import com.hmei.hibernate.entity.Customer;
import com.hmei.hibernate.entity.Product;
import com.hmei.hibernate.model.SearchForm;
import com.hmei.spring.exceptionhandler.ProductConversionException;

public interface ProductService {

	Product findById(String category, long id);
	Product findById(long id);
	Set<Product> getPage(SearchForm searchForm, int firstResult, int maxResult) throws  ProductConversionException;
	long countRow(SearchForm searchForm);
	void checkOut(Customer customer);
}
