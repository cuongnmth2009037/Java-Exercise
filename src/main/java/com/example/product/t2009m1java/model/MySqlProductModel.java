package com.example.product.t2009m1java.model;

import com.example.product.t2009m1java.constant.SqlConstant;
import com.example.product.t2009m1java.entity.Product;
import com.example.product.t2009m1java.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySqlProductModel implements ProductModel {

    @Override
    public boolean save(Product product) {
       try {
           Connection connection = ConnectionHelper.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_INSERT);
           preparedStatement.setString(1, product.getName());
           preparedStatement.setString(2, product.getDescription());
           preparedStatement.setString(3, product.getDetail());
           preparedStatement.setDouble(4, product.getPrice());
           preparedStatement.setString(5, product.getThumbnail());
           preparedStatement.setString(6, product.getManufactureEmail());
           preparedStatement.setString(7, product.getManufacturePhone());
           preparedStatement.setString(8, product.getCreatedAt().toString());
           preparedStatement.setString(9, product.getUpdatedAt().toString());
           if (product.getDeletedAt() != null){
               preparedStatement.setString(10, product.getDeletedAt().toString());
           }else {
               preparedStatement.setString(10, null);
           }
           preparedStatement.setInt(11, product.getCreatedBy());
           preparedStatement.setInt(12, product.getUpdatedBy());
           preparedStatement.setInt(13, product.getDeletedBy());
           preparedStatement.setInt(14, product.getStatus().getValue());
           return true;

       }catch (SQLException e){
           e.printStackTrace();
           System.out.println(e);
       }
       return false;
    }

    @Override
    public boolean update(int id, Product product) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
