package com.ssafy.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.service.ProductService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> list(){
		return new ResponseEntity<List<Product>>(productService.getProductList(), HttpStatus.OK);
	}
	
	@GetMapping("/product/{p_id}")
	public ResponseEntity<Product> search(@PathVariable("p_id") int p_id){
		return new ResponseEntity<Product>(productService.getProduct(p_id), HttpStatus.OK) ;
	}
	
	@PostMapping("/product")
	public ResponseEntity<String> write(@RequestBody Product product){
		productService.writeProduct(product);
		return new ResponseEntity<String>("완료", HttpStatus.OK) ;
	}
	
	@PutMapping("/product")
	public ResponseEntity<String> modify(@RequestBody Product product){
		productService.modifyProduct(product);
		return new ResponseEntity<String>("완료", HttpStatus.OK) ;
	}
	
	@DeleteMapping("/product/{p_id}")
	public ResponseEntity<String> delete(@PathVariable("p_id") int p_id){
		productService.removeProduct(p_id);
		return new ResponseEntity<String>("완료", HttpStatus.OK) ;
	}
}
