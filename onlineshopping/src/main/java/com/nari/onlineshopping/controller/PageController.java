package com.nari.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class PageController 
{
	@RequestMapping(value={"/","/home","/index"})
public String index(ModelMap map)
{
		dispat
		map.addAttribute("msg","welcome to onlineshopping");
	return "index";
}
}
