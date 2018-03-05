package com.hmei.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hmei.hibernate.entity.Cart;


@Repository
public class CustomerCartDaoImp implements CustomerCartDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int save(Cart cart) {
		
		return (int)ht.save(cart);
	}

	@Override
	public void update(Cart cart) {
		ht.update(cart);
		
	}

	@Override
	public void delete(Cart cart) {
		ht.delete(cart);
	}

	@Override
	public Cart findByPrimaryKey(int id) {
		return ht.get(Cart.class, id);
	}

}
