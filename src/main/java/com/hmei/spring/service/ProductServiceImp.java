package com.hmei.spring.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmei.hibernate.entity.Cart;
import com.hmei.hibernate.entity.Customer;
import com.hmei.hibernate.entity.Product;
import com.hmei.hibernate.model.SearchForm;
import com.hmei.spring.dao.CustomerCartDaoImp;
import com.hmei.spring.dao.ProductDao;
import com.hmei.spring.exceptionhandler.ProductConversionException;

@Service
@Transactional
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductDao productDaoImp;
	
	@Autowired
	private CustomerCartDaoImp customerCartDaoImp;
	
	@Override
	public Product findById(String category, long id) {
		return productDaoImp.getById(category, id);

	}
	
	@Override
	public Product findById(long id) {
		return productDaoImp.getById(id);
	}

	@Override
	public Set<Product> getPage(SearchForm searchForm,int firstResult, int maxResult) throws ProductConversionException  {
		Set<Product> result =  productDaoImp.getPage(searchForm,firstResult, maxResult);
		return result;
	}
	public long countRow(SearchForm searchForm) {
		return productDaoImp.countRow(searchForm);
	}

	@Override
	public void checkOut(Customer customer) {
		Cart cart = customer.getCart();
		Map<Product, Integer> items = cart.getItemList();
		Set<Entry<Product, Integer>> set = items.entrySet();
		Iterator<Entry<Product, Integer>> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Entry<Product, Integer> entry = iterator.next();
			productDaoImp.update(entry.getKey().getId(), entry.getValue());
		}
		cart.setItemList(new HashMap<Product, Integer>());
		customerCartDaoImp.update(cart);
	}
	

}
