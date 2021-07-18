package com.jpa.springboot.productdata;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jpa.springboot.productdata.entity.Product;
import com.jpa.springboot.productdata.repository.ProductRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductdataApplicationTests {

  @Autowired
  ProductRepository repository;

	@Test
	public void contextLoads() {
	}

  @Test
  public void testCreate() {
    Product product = new Product();
    product.setId(1);
    product.setName("Iphone");
    product.setDesc("Iphone 11 Pro Max");
    product.setPrice(1000d);

    repository.save(product);
  }

  @Test
  public void testRead() {
    Product product = repository.findById(1).get();
    assertNotNull(product);
    assertEquals("Iphone", product.getName());
  }

  @Test
  public void testUpdate() {
    Product product = repository.findById(1).get();
    product.setPrice(1200d);
    repository.save(product);
  }
}
