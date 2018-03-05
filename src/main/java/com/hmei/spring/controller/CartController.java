package com.hmei.spring.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hmei.hibernate.entity.Cart;
import com.hmei.hibernate.entity.Customer;
import com.hmei.hibernate.entity.Product;
import com.hmei.spring.service.CustomerCartService;
import com.hmei.spring.service.CustomerService;
import com.hmei.spring.service.ProductService;


@Controller
@SessionAttributes(value = { "customer", "searchForm" })
@RequestMapping(value="/user/cart")
public class CartController {

	@Autowired
	private CustomerService customerServiceImp;
	
	@Autowired
	private CustomerCartService customerCartServiceImp;

	@Autowired
	private ProductService productServiceImp;
	
	@PostMapping(value = "/{id}")
	public String addToCart(
			@ModelAttribute("customer") Customer customer, 
			@RequestParam("amount") int amount,
			@PathVariable("id") long id
			) {
		boolean hasCart = true;
		Cart cart = customer.getCart();
		if (cart == null) {
			System.out.println("cart is null");
			hasCart = false;
			cart = new Cart();
			customer.setCart(cart);
		}
		Product product = productServiceImp.findById(id);
		Map<Product, Integer> map = cart.getItemList();
		if (map.containsKey(product)) {
			map.put(product, map.get(product) + amount);
		} else {
			map.put(product, amount);
		}
		
		if(hasCart)
		{
			customerCartServiceImp.update(cart);
		}
		else
		{
			customerServiceImp.update(customer);
		}

		return "redirect:/user/cart";
	}

	@GetMapping(value = "")
	public String goToCart() {
		return "cart";
	}
	
	@DeleteMapping(value= "")
	@ResponseBody
	public String checkOut(@ModelAttribute("customer")Customer customer,
			HttpServletRequest request) {
		productServiceImp.checkOut(customer);
		request.getSession().setAttribute("customer", customer);
		return "";
	}
	
	
	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public String deleteItem(
			@ModelAttribute("customer") Customer customer,
			HttpServletRequest request, 
			@PathVariable("id") long id
			) {
		System.out.println("delete method in controller!");
		int deletedAmount = 0;
		Map<Product, Integer> map = customer.getCart().getItemList();
		Set<Product> set = map.keySet();
		Iterator<Product> iterator = set.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.getId() == id) {
				deletedAmount = map.get(product);
				iterator.remove();
				break;
			}
		}
		customerCartServiceImp.update(customer.getCart());
		request.getSession().setAttribute("customer", customer);
		return String.valueOf(deletedAmount);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateAmount(
			@ModelAttribute Customer customer,
			HttpServletRequest request, 
			@PathVariable("id") long id, 
			@RequestBody String quantity)
			throws ParseException {
		System.out.println("update method in controller!");
		double newPrice = 0;
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(quantity);
		String quantityString = (String) json.get("quantity");
		int quantityInt = Integer.parseInt(quantityString);

		Map<Product, Integer> map = customer.getCart().getItemList();
		Set<Product> set = map.keySet();
		Iterator<Product> iterator = set.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.getId() == id) {
				newPrice = product.getPrice() * quantityInt;
				map.put(product, quantityInt);
				break;
			}
		}
		customerCartServiceImp.update(customer.getCart());
		request.getSession().setAttribute("customer", customer);
		
		return String.valueOf(newPrice);
	}
}
