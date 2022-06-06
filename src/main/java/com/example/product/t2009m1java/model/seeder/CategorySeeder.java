package com.example.product.t2009m1java.model.seeder;

import com.example.product.t2009m1java.entity.Category;
import com.example.product.t2009m1java.model.CategoryModel;
import com.example.product.t2009m1java.model.MySqlCategoryModel;

public class CategorySeeder {
    private CategoryModel categoryModel;

    public CategorySeeder() {
        this.categoryModel = new MySqlCategoryModel();
    }

    public void seedData() {
        categoryModel.save(Category.CategoryBuilder.aCategory()
                .name("Đồ gia dụng").build());
        categoryModel.save(Category.CategoryBuilder.aCategory()
                .name("Điện thoại").build());
        categoryModel.save(Category.CategoryBuilder.aCategory()
                .name("Máy tính").build());
    }
}
