package com.spring.Productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Productapp.entities.Product;
import com.spring.Productapp.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@GetMapping("/getProduct/{Productid}")
	public Product getProduct(@PathVariable int productId) {
		return service.getProductById(productId);
	}
	
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}
	
	@GetMapping("/Products")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/getProduct/{ProductName}")
	public Product getProductByName(@PathVariable String productName) {
		return service.getProductByName(productName);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("delete/{ProductId}")
	public String deleteProduct(@PathVariable int ProductId) {
		return service.deleteProduct(ProductId);
	}
	
	
	
	
}
