package com.jpa.springboot.productdata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

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

  @Test
  public void testDelete() {
    if (repository.existsById(1)) {
      repository.deleteById(1);
    }
  }

  @Test
  public void testCound() {
    repository.count();
  }

  @Test
  public void testFindByPriceGreaterThan() {
    List<Product> products = repository.findByPriceGreaterThan(500d);
    products.forEach(p -> System.out.println(p.getPrice()));
  }

  @Test
  public void testFindByDescContains() {
    List<Product> products = repository.findByDescContains("Iphone");
    products.forEach(p -> System.out.println(p.getName()));
  }

  @Test
  public void testFindByPriceBetween() {
    List<Product> products = repository.findByPriceBetween(900d, 50000d);
    products.forEach(p -> System.out.println(p.getName()));
  }

  @Test
  public void testFindByDescLike() {
    List<Product> products = repository.findByDescLike("%max%");
    products.forEach(p -> System.out.println(p.getName()));
  }


  @Test
  public void testFindByIdIn() {
    List<Product> products = repository.findByIdIn(Arrays.asList(1 ,2));
    products.forEach(p -> System.out.println(p.getName()));
  }
}
