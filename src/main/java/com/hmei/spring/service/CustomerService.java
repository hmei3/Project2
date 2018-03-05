package com.hmei.spring.service;

import com.hmei.hibernate.entity.Customer;

public interface CustomerService {
	
	void register(Customer customer);
	void update(Customer customer);
	Customer findCustomer(String email);
}
