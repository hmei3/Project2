package com.hmei.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="pro2_customer")
public class Customer {
	
	@Id
	@Column(name="email", nullable=false)
	@NotEmpty
	@Email
	private String email;
	

	@Pattern(regexp="[a-zA-Z]+(\\s[a-zA-Z]+)*", message="only letters with non-continuous spaces are allowed")
	@Size(min=2, max=50)
	@Column(nullable=false)
	private String name;
	
//	@ManyToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="pro2_customer_address",
//			joinColumns=@JoinColumn(name="email"),
//			inverseJoinColumns=@JoinColumn(name="addr_id"))
//	private Set<Address> address;
//	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="pro2_customer_payment",
//	joinColumns=@JoinColumn(name="email"),
//	inverseJoinColumns=@JoinColumn(name="payment_id"))
//	private Set<Payment> payments;
	

	@Pattern(regexp="[0-9A-Za-z]+", message="must be letters or numbers!")
	@Size(min=5, max=10)
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL,
			fetch=FetchType.EAGER)
	private Cart cart;
	
//Constructor
	
	public Customer() {}
	public Customer(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

//Getter and Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("customer setter called");
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
