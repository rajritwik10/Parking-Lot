package com.spring.Productapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Productapp.entities.Product;
import com.spring.Productapp.repository.Productrepository;

@Service
public class ProductService {
	@Autowired
	private Productrepository repository;
	
//	List<Product>products=new ArrayList<>();
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product>saveProducts(List<Product>products){
		return repository.saveAll(products);
	}
	
	public Product getProductById(int ProductId) {
		/*
		 * Product temp=null; for(Product ele:products) { if(ele.getId()==ProductId) {
		 * temp=ele; break; } } return temp;
		 */
		return repository.findById(ProductId).orElse(null);
		
	}
	public List<Product>getProducts(){
		return repository.findAll();
	}
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	
	public String  deleteProduct(int ProductId) {
		repository.deleteById(ProductId);
		return "Product Removed Successfully"+ProductId;
	}
	
	public Product updateProduct(Product product) {
		Product Existing=repository.findById(product.getId()).orElse(null);
		Existing.setName(product.getName());
		Existing.setQuantity(product.getQuantity());
		Existing.setPrice(product.getPrice());
		return repository.save(Existing);
	}
	
}
