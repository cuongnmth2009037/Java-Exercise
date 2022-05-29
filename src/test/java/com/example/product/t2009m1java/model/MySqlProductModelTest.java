package com.example.product.t2009m1java.model;

import com.example.product.t2009m1java.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {
    private  ProductModel productModel;

    @BeforeEach
    void setUp() {
        productModel = new MySqlProductModel();
    }

    @Test
    void save() {
        Product product = new Product("Tao","Ngon","Xuat su My",20000,"tao.png","cuong@gmail.com","0999999999");
        assertEquals(true, productModel.save(product));
    }
    @Test
    void update() {
        Product product = new Product(1,"Dua Le", "Dua le xuat su viet nam", "Dua le khong chat bao quan", 100, "https://yt.cdnxbvn.com/medias/uploads/58/58852-41.jpg", "lananh@gmail.com","0999999999");
        assertEquals(true, productModel.update(7, product));
    }

    @Test
    void delete() {
       productModel.delete(7);
    }

    @Test
    void findById() {
        List<Product>  products = productModel.findAll();
        assertNotEquals(0, products.size());
        Product product = products.get(0);
        Product productFind = productModel.findById(product.getId());
        assertEquals(product.getId(), productFind.getId());
    }

    @Test
    void findAll() {
        List<Product> products = productModel.findAll();
        assertNotEquals(0, products.size());
    }




}