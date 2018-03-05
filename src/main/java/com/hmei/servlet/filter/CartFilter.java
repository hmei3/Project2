package com.hmei.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		if(httpRequest.getSession().getAttribute("customer") == null) {
			System.out.println("CartFilter: 1");
			((HttpServletResponse)response).sendRedirect("/Project2/user/login");
			return;
		}
		System.out.println("CartFilter: 2");
		chain.doFilter(request, response);
	}

}
