package com.hmei.spring.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value=RuntimeException.class)
	public String runtimeExceptionHandler(Exception exception, Model model) {
		System.out.println("into my customized error handler!");
		System.out.println(exception.getClass());
		
		model.addAttribute("errorMessage", exception.getClass().getSimpleName());
		return "errorPage";
	}
	
	@ExceptionHandler(value=ProductConversionException.class) 
	public String productConversionExceptionHandler(Exception exception, Model model) {
		System.out.println("into my customized error handler!");
		System.out.println(exception.getClass());
		
		model.addAttribute("errorMessage", exception.getClass().getSimpleName());
		return "errorPage";
	}
}
