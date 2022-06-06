package com.example.product.t2009m1java.model;

import com.example.product.t2009m1java.entity.Category;
import com.example.product.t2009m1java.entity.Product;

import java.util.List;

public interface CategoryModel {
    boolean save(Category category);
    boolean update(int id, Category category);
    boolean delete(int id);
    Category findById(int id);
    List<Category> findAll();
}
