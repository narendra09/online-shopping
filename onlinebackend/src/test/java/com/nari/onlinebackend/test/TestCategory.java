package com.nari.onlinebackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nari.onlinebackend.dao.CategoryDao;
import com.nari.onlinebackend.dto.Category;

import junit.framework.Assert;

public class TestCategory{
	private static AnnotationConfigApplicationContext context=null;
	private static CategoryDao dao;
    private Category c;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.nari.onlinebackend");
		context.refresh();
		dao=(CategoryDao)context.getBean("categoryDAO");
	}
	/*@SuppressWarnings("deprecation")
	@Test
	public void testAdd()
	{
		c=new Category();
		c.setDescription("This is some description for fridge");
		c.setName("fridge");
		c.setImageUrl("CAT_3.png");
		Assert.assertEquals("category object not saved", true, dao.add(c));
	}
	*/
/*	@SuppressWarnings("deprecation")
	@Test
	public void testGet()
	{
		Category c=dao.get(1);
		Assert.assertEquals("category object not loaded", "Television", c.getName());
	}
	*/
	/*@Test
	public void testUpdate()
	{
		c=dao.get(1);
		c.setName("Tv");
		
		Assert.assertEquals("category object not updated", true, dao.update(c));
	}*/
	
	
/*	@Test
	public void testDelete()
	{
		c=dao.get(1);

		
		Assert.assertEquals("category object not updated", true, dao.delete(c));
	}*/
	
	@Test
	public void testList()
	{

		Assert.assertEquals("category object list not loaded", 2, dao.list().size());
	}

}