package com.hmei.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hmei.hibernate.entity.Customer;
import com.hmei.spring.service.CustomerService;

@Controller
@SessionAttributes(value = { "customer", "searchForm" })
@RequestMapping("/user")
public class UserController {

	@Autowired
	private CustomerService customerServiceImp;


	@GetMapping(value = "/login")
	public String login(ModelMap model) {
		model.addAttribute("user", new Customer());
		return "login";
	}

	@GetMapping(value = "/register")
	public String register(Model model) {
		model.addAttribute("user", new Customer());
		return "register";
	}

	@PostMapping(value = "/logging-in")
	public String loggingIn(HttpServletRequest request, @Valid @ModelAttribute("user") Customer customer,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return "login";
		}
		Customer tempCustomer = customerServiceImp.findCustomer(customer.getEmail());
		if (tempCustomer != null && tempCustomer.getPassword().equals(customer.getPassword())) {
			request.getSession().removeAttribute("user");
			request.getSession().setAttribute("customer", tempCustomer);
			return "redirect:/index";
		} else {
			request.getSession().setAttribute("loginErrorMsg", "Email or password is wrong!");
			return "redirect:login";
		}
	}

	@PostMapping(value = "/registering")
	public String registering(@Valid @ModelAttribute("user") Customer register, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "register";
		}
		Customer tempCustomer = customerServiceImp.findCustomer(register.getEmail());
		if (tempCustomer != null) {
			model.addAttribute("registerErrorMsg", "This email is already being used!");
			return "redirect:register";
		}
		customerServiceImp.register(register);

		return "redirect:login";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request, SessionStatus status) {
		System.out.println("logout method called");
		status.setComplete();
		return "redirect:/index";
	}

}
