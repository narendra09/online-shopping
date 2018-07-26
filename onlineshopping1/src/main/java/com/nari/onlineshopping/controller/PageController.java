package com.nari.onlineshopping.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nari.onlinebackend.dao.CategoryDao;
import com.nari.onlinebackend.dao.ProductDao;
import com.nari.onlinebackend.dto.Category;
import com.nari.onlinebackend.dto.Product;
@Controller
public class PageController {
	
	private static final Logger logger=LoggerFactory.getLogger("PageController.class");
    @Autowired
	private CategoryDao dao;
	
    @Autowired
    private ProductDao productDAo;
		@RequestMapping("/index")
	public String index(ModelMap map)
	{
			logger.info("inside indexmethod-INFO");
			logger.debug("inside index method-Debug");
			map.addAttribute("title","HOME");
			map.addAttribute("userClickHome","true");
			map.addAttribute("categories", dao.list());
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
		
		@RequestMapping("/show/all/products")
		public String allProducts(ModelMap map)
		{
				
				map.addAttribute("title","All products");
				map.addAttribute("categories", dao.list());
				map.addAttribute("userClickAllProducts","true");
			return "index";
		}
		
		@RequestMapping("/show/category/{id}/products")
		public String showCategoryProducts(@PathVariable("id") int id,ModelMap map)
		{
				//categorydao to fetch single category
			Category category=null;
			category=dao.get(id);
				map.addAttribute("title",category.getName());
				map.addAttribute("categories", dao.list());
				map.addAttribute("category", category);
				map.addAttribute("userClickCategoryProducts","true");
			return "index";
		}
		@RequestMapping("/show/{id}/product")
		public String showSingleProduct(@PathVariable("id") int id,ModelMap map)
		{
			Product product=productDAo.get(id); 
			
			product.setViews(product.getViews()+1);
			productDAo.update(product);
			map.addAttribute("userClickShowProduct","true");
			
			map.addAttribute("title",product.getName());
			map.addAttribute("product",product);
			return "index";
		}
	}


