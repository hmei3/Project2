package com.hmei.spring.service;

import com.hmei.hibernate.entity.Cart;

public interface CustomerCartService {
	int save(Cart cart);
	void update(Cart cart);
	void delete(Cart cart);
	Cart findCart(int id);
}
