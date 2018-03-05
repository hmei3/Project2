package com.hmei.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hmei.hibernate.entity.Customer;

@Repository
public class CustomerDaoImp implements CustomerDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public String save(Customer customer) {
		String id = (String)ht.save(customer);
		System.out.println("save method is called");
		return id;
	}

	@Override
	public void update(Customer customer) {
		ht.update(customer);
	}

	@Override
	public void delete(Customer customer) {
		ht.delete(customer);
	}

	@Override
	public Customer findByPrimaryKey(String email) {
		Customer customer = ht.get(Customer.class, email);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		return ht.loadAll(Customer.class);
	}

}
