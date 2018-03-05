package com.hmei.spring.controller;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hmei.hibernate.entity.Product;
import com.hmei.hibernate.model.SearchForm;
import com.hmei.spring.exceptionhandler.ProductConversionException;
import com.hmei.spring.service.ProductService;

@Controller
@RequestMapping("/search")
@SessionAttributes("searchForm")
public class SearchController {
	@Autowired
	private ProductService productSearchServiceImp;
	
	private int maxResult = 4;
	
	@GetMapping(value= {"/page/{page}"})
	public String search(
			@ModelAttribute("searchForm") SearchForm searchForm, 
			Model model,
			@PathVariable("page") int page) throws ProductConversionException   {
		Set<Product> result = productSearchServiceImp.getPage(searchForm, (page - 1) * maxResult, maxResult);
		double totalRows = productSearchServiceImp.countRow(searchForm);
		System.out.println("totalRows: " + totalRows);
		double pages = Math.ceil(totalRows/maxResult);
		System.out.println("pages: " + pages);
		model.addAttribute("result", result);
		
		Iterator<Product> iterator = result.iterator();
		while(iterator.hasNext()) {
			Product p = iterator.next();
			System.out.println(p.getName());
			System.out.println(p.getImage());
		}
		
		model.addAttribute("curPage", page);
		model.addAttribute("maxResult", maxResult);
		model.addAttribute("pages", pages);
		return "search";
	}
	
	@GetMapping(value= {""})
	public String search(
			@ModelAttribute("searchForm") SearchForm searchForm, 
			Model model) throws ProductConversionException {
		System.out.println("Model Search Form Category: " + searchForm.getCategory());
		Set<Product> result = productSearchServiceImp.getPage(searchForm,0, maxResult);
		System.out.println(result.size());
		double totalRows = productSearchServiceImp.countRow(searchForm);
		System.out.println("totalRows: " + totalRows);
		double pages = Math.ceil(totalRows/maxResult);
		System.out.println("pages: " + pages);
		model.addAttribute("result", result);
		
		model.addAttribute("curPage", 0);
		model.addAttribute("maxResult", maxResult);
		model.addAttribute("pages", pages);
		return "search";
	}
	
}
