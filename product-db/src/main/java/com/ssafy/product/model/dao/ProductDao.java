package com.ssafy.product.model.dao;

import java.util.List;

import com.ssafy.product.model.dto.Product;

public interface ProductDao {
	
	public List<Product> selectAll();
	public Product selectOne(int p_id);
	public void insertProduct(Product product);
	public void deleteProduct(int p_id);
	public void updateProduct(Product product);
	
}
