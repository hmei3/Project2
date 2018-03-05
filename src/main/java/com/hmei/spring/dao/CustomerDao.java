package com.hmei.spring.dao;

import java.util.List;

import com.hmei.hibernate.entity.Customer;

public interface CustomerDao {
	String save(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	Customer findByPrimaryKey(String email);
//	Customer findByName(String name);
	List<Customer> findAll();
	
}
