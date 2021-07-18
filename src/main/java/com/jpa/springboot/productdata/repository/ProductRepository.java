package com.jpa.springboot.productdata.repository;

import com.jpa.springboot.productdata.entity.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}