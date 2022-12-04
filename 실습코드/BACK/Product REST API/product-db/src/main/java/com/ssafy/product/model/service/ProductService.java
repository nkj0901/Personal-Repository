package com.ssafy.product.model.service;

import java.util.List;

import com.ssafy.product.model.dto.Product;

public interface ProductService {
	
	//모두 조회
	List<Product> getProductList();
	
	//하나만 조회
	Product getProduct(int p_id);
	
	//삭제
	void removeProduct(int p_id);
	
	//등록
	void writeProduct(Product product);
	
	//수정
	void modifyProduct(Product product);
}
