package com.nari.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {

	
		@RequestMapping("/index")
	public String index(ModelMap map)
	{
			
			map.addAttribute("title","HOME");
			map.addAttribute("userClickHome","true");
		return "index";
	}
		
		@RequestMapping(value="/about")
		public String about(ModelMap map)
		{
			
				
				map.addAttribute("title","ABoutUs");
				map.addAttribute("userClickAbout","true");
			return "index";
		}
		
		@RequestMapping("/contact")
		public String contact(ModelMap map)
		{
				
				map.addAttribute("title","Contact US");
				map.addAttribute("userClickContact","true");
			return "index";
		}
	}


