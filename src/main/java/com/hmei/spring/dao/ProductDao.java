package com.hmei.spring.dao;

import java.util.Set;

import com.hmei.hibernate.entity.Product;
import com.hmei.hibernate.model.SearchForm;
import com.hmei.spring.exceptionhandler.ProductConversionException;

public interface ProductDao {
	
	Product getById(String category, long id);
	Product getById(long id);
	Set<Product> getPage(SearchForm searchForm,int firstResult, int maxResult) throws ProductConversionException;
	long countRow(SearchForm searchForm);
	
	void update(long pId, int amount);
}
