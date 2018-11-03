package com.nari.ExceptionHandling;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler
{

	@ExceptionHandler(NoHandlerFoundException.class)
	public String handlerNoHandlerFoundException(ModelMap map)
	{
		map.addAttribute("errorTitle", "The page is not constructed");
		map.addAttribute("errorDescription", "The page you are looking is not available");
		map.addAttribute("title", "404 error");
		return "error";
	}
}
