package com.hmei.spring.dao;

import com.hmei.hibernate.entity.Cart;

public interface CustomerCartDao {
	
	int save(Cart cart);
	void update(Cart cart);
	void delete(Cart cart);
	Cart findByPrimaryKey(int id);
}
