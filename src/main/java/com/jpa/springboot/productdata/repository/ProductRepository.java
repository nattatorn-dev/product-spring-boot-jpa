package com.jpa.springboot.productdata.repository;

import java.util.List;

import com.jpa.springboot.productdata.entity.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
  List<Product> findByName(String name);
  List<Product> findByNameAndDesc(String name, String desc);
  List<Product> findByPriceGreaterThan(Double price);
  List<Product> findByDescContains(String desc);
  List<Product> findByPriceBetween(Double priceFrom, Double priceTo);
  List<Product> findByDescLike(String desc);
  List<Product> findByIdIn(List<Integer> ids);
}