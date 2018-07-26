package com.nari.onlinebackend.dao;

import java.util.List;

import com.nari.onlinebackend.dto.Category;
import com.nari.onlinebackend.dto.Product;

public interface ProductDao
{
  List<Product> list();
  Product get(int id);
  boolean add(Product product);
  boolean update(Product product);
   boolean delete(Product product);
   
   //business methods
   List<Product> listActiveProducts();
   List<Product> listActiveProductsByCategory(int categoryId);
   List<Product> getLatestActiveProducts(int count);
}
