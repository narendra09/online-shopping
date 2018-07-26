package com.nari.onlinebackend.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nari.onlinebackend.dao.ProductDao;
import com.nari.onlinebackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDao productDAO;
	
	
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.nari.onlinebackend");
		context.refresh();
		productDAO = (ProductDao)context.getBean("productDAO");
	}
	
	/*@Test
	public void testCRUDProduct() {
		
		// create operation
		product = new Product();
				
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitprice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		Assert.assertEquals("Something went wrong while inserting a new product!",
				true,productDAO.add(product));		
		
		
		// reading and updating the category
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		Assert.assertEquals("Something went wrong while updating the existing record!",
				true,productDAO.update(product));		
				
		Assert.assertEquals("Something went wrong while deleting the existing record!",
				true,productDAO.delete(product));		
		
		// list
		Assert.assertEquals("Something went wrong while fetching the list of products!",
				6,productDAO.list().size());		
				
	}*/
			
	
/*	@Test
	public void testListActiveProducts() {
		Assert.assertEquals("Something went wrong while fetching the list of products!",
				5,productDAO.listActiveProducts().size());				
	} */
	
	
	/*@Test
	public void testListActiveProductsByCategory() {
		Assert.assertEquals("Something went wrong while fetching the list of products!",
				3,productDAO.listActiveProductsByCategory(3).size());
		Assert.assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.listActiveProductsByCategory(1).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() {
		Assert.assertEquals("Something went wrong while fetching the list of products!",
				3,productDAO.getLatestActiveProducts(3).size());
		
	} 
	*/
	
	
		
}
