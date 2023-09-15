package com.ssafy.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.model.dao.ProductDao;
import com.ssafy.product.model.dto.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productdao;
	
	@Override
	public List<Product> getProductList() {
		return productdao.selectAll();
	}

	@Override
	public Product getProduct(int p_id) {
		return productdao.selectOne(p_id);
	}

	@Override
	public void writeProduct(Product product) {
		productdao.insertProduct(product);
	}
	
	@Override
	public void removeProduct(int p_id) {
		productdao.deleteProduct(p_id);
	}

	@Override
	public void modifyProduct(Product product) {
		productdao.updateProduct(product);
	}

}
