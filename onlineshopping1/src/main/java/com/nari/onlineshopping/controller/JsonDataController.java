package com.nari.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nari.onlinebackend.dao.ProductDao;
import com.nari.onlinebackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController 
{
    @Autowired
	private ProductDao productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts()
	{
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getAllProductsByCategoryId(@PathVariable("id") int id)
	{
		return productDAO.listActiveProductsByCategory(id);
	}
}
