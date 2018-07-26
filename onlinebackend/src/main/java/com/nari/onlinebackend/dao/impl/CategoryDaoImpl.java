package com.nari.onlinebackend.dao.impl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nari.onlinebackend.dao.CategoryDao;
import com.nari.onlinebackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sf;
   

	
	
	public List<Category> list() {
		String hql="from Category where active=:active";
		Query q=sf.getCurrentSession().createQuery(hql);
		q.setParameter("active", true);
		return q.getResultList();
	}

	public Category get(int id)
	{
		
		/*for(Category category:categories)
		{
			if(category.getId()==id)
				{
				return category;
				}
				}*/
		
		Category c=sf.getCurrentSession().get(Category.class, id);
		return c;
	}

	public boolean add(Category category) {
		try{
		
			//add the category to data base
			
			
			
			sf.getCurrentSession().save(category);
			
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

public boolean update(Category category) {
	
	try{
		
		//update the category intoto data base
		
		
		
		sf.getCurrentSession().update(category);
		
		return true;
	}catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	
}


public boolean delete(Category category) {
category.setActive(false);
try{
	
	//update the category intoto data base
	
	
	
	sf.getCurrentSession().update(category);
	
	return true;
}catch(Exception e)
{
	e.printStackTrace();
	return false;
}
}

}
