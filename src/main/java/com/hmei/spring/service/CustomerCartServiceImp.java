package com.hmei.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmei.hibernate.entity.Cart;
import com.hmei.spring.dao.CustomerCartDao;


@Service
@Transactional
public class CustomerCartServiceImp implements CustomerCartService {

	@Autowired
	private CustomerCartDao customerCartDaoImp;
	
	@Override
	public int save(Cart cart) {
		return customerCartDaoImp.save(cart);
	}

	@Override
	public void update(Cart cart) {
		customerCartDaoImp.update(cart);

	}

	@Override
	public void delete(Cart cart) {
		customerCartDaoImp.delete(cart);

	}

	@Override
	public Cart findCart(int id) {
		return customerCartDaoImp.findByPrimaryKey(id);
	}

}
