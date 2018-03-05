package com.hmei.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hmei.hibernate.model.SearchForm;


public class SearchFormFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		System.out.println("SearchFormFilter: " + httpRequest.getServletPath().toString());
		
		if((httpRequest.getContextPath() + httpRequest.getServletPath()).equals("/Project2/index"))
		{
			System.out.println("SearchFormFilter: 1");
			chain.doFilter(request, response);
			return;
		}
		if(httpRequest.getSession().getAttribute("searchForm") == null)
		{
			System.out.println("SearchFormFilter: 2");
			((HttpServletResponse)response).sendRedirect("/Project2/index");
			return;
		}
		System.out.println("SearchFormFilter: 3");
		System.out.println("Session SearchFormFilter category: " + 
		((SearchForm)(httpRequest.getSession().getAttribute("searchForm"))).getCategory());
		chain.doFilter(request, response);
	}

}
