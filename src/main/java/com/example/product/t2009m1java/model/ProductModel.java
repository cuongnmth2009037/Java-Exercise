package com.example.product.t2009m1java.model;

import com.example.product.t2009m1java.entity.Product;

import java.util.List;

public interface ProductModel {
    boolean save(Product product);
    boolean update(int id, Product product);
    boolean delete(int id);
    Product findById(int id);
    List<Product> findAll();
}
