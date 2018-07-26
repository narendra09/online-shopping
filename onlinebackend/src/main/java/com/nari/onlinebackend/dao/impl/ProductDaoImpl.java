package com.nari.onlinebackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nari.onlinebackend.dao.ProductDao;
import com.nari.onlinebackend.dto.Product;
@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	private SessionFactory sf;
	public List<Product> list() {
		
		return sf
				.getCurrentSession()
					.createQuery("FROM Product" , Product.class)
						.getResultList();

	}

	public Product get(int id) {
	 Product p=sf.getCurrentSession().get(Product.class, id);
		return p;
	}

	public boolean add(Product product) {
		try{
			
			//add the product to data base
		    sf.getCurrentSession().save(product);
           return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		try {			
			
					sf.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;		
	}



	public boolean delete(Product product) {
	
		try {
			
			product.setActive(false);
			// call the update method
			return this.update(product);
		}
		catch(Exception ex) {		
			ex.printStackTrace();
			return false;
		}		
		

	}

	public List<Product> listActiveProducts() {
		

			String selectActiveProducts = "FROM Product WHERE active = :active";
			return sf
					.getCurrentSession()
						.createQuery(selectActiveProducts, Product.class)
							.setParameter("active", true)
								.getResultList();
		}

	

	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sf
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory, Product.class)
						.setParameter("active", true)
						.setParameter("categoryId",categoryId)
							.getResultList();

	}

	public List<Product> getLatestActiveProducts(int count) {
		return sf
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();	
	}

}
