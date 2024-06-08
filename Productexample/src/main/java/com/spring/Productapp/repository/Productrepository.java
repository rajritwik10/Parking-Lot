package com.spring.Productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Productapp.entities.Product;

public interface Productrepository extends JpaRepository<Product,Integer>{

	Product findByName(String name);
	
}
