package com.hmei.spring.controller;

import java.io.UnsupportedEncodingException;

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
import com.hmei.spring.service.ProductService;

@Controller
@RequestMapping("/product")
@SessionAttributes("searchForm")
public class ProductController {

	@Autowired
	private ProductService productSearchServiceImp;

	@GetMapping("/details/{pCategory}/{id}")
	public String getDetails(@ModelAttribute SearchForm searchForm, @PathVariable("id") long id,
			@PathVariable("pCategory") String pCategory, Model model) throws UnsupportedEncodingException {
		Product product = productSearchServiceImp.findById(pCategory, id);		
		String description = product.getDescription().replaceAll("(\r\n|\n)", "</p><p>");
		product.setDescription(description.toString());
		
		model.addAttribute("product", product);
		if(pCategory.equals("Computer"))
			return "computer";
		else if(pCategory.equals("Book"))
			return "book";
		else if(pCategory.equals("Toy"))
			return "toy";
		else if(pCategory.equals("Grocery"))
			return "grocery";
		else
		{
			model.addAttribute("errorMessage", pCategory + " is not available");
			return "errorPage";
		}
	}
}
