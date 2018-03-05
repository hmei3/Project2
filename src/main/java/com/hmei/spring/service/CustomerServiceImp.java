package com.hmei.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmei.hibernate.entity.Customer;
import com.hmei.spring.dao.CustomerDao;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerDao customerDaoImp;
	
	@Override
	public void register(Customer customer) {
		customerDaoImp.save(customer);

	}

	@Override
	public void update(Customer customer) {
		customerDaoImp.update(customer);

	}

	@Override
	public Customer findCustomer(String email) {
		return customerDaoImp.findByPrimaryKey(email);
	}

}
