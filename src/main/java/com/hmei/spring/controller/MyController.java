package com.hmei.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hmei.hibernate.model.SearchForm;

@Controller
public class MyController {
	@GetMapping(value= {"/index"})
	public String index(HttpServletRequest request, Model model) {
		SearchForm searchForm = new SearchForm();
		request.getSession().setAttribute("searchForm", searchForm);
		model.addAttribute("searchForm", searchForm);
		return "index";
	}
	
}
