package com.example.product.t2009m1java.model;

import com.example.product.t2009m1java.constant.SqlConstant;
import com.example.product.t2009m1java.entity.Category;
import com.example.product.t2009m1java.entity.Product;
import com.example.product.t2009m1java.entity.entityEnum.ObjectStatus;
import com.example.product.t2009m1java.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlCategoryModel implements CategoryModel {
    @Override
    public boolean save(Category category) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.CATEGORY_INSERT);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getCreatedAt().toString());
            preparedStatement.setString(3, category.getUpdatedAt().toString());
            preparedStatement.setInt(4, category.getCreatedBy());
            preparedStatement.setInt(5, category.getUpdatedBy());
            preparedStatement.setInt(6, category.getStatus().getValue());
            if (category.getDeletedAt() != null){
                preparedStatement.setString(7, category.getDeletedAt().toString());
            }else {
                preparedStatement.setString(7, null);
            }
            preparedStatement.setInt(8, category.getCreatedBy());
            preparedStatement.setInt(9, category.getUpdatedBy());
            preparedStatement.setInt(10, category.getDeletedBy());
            preparedStatement.setInt(11, category.getStatus().getValue());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean update(int id, Category category) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.CATEGORY_UPDATE);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getUpdatedAt().toString());
            preparedStatement.setInt(3, category.getUpdatedBy());
            preparedStatement.setInt(4, category.getStatus().getValue());
            preparedStatement.setInt(5, id);
            if (category.getDeletedAt() != null){
                preparedStatement.setString(6, category.getDeletedAt().toString());
            }else {
                preparedStatement.setString(6, null);
            }
            preparedStatement.setInt(7, category.getCreatedBy());
            preparedStatement.setInt(8, category.getUpdatedBy());
            preparedStatement.setInt(9, category.getDeletedBy());
            preparedStatement.setInt(10, category.getStatus().getValue());
            preparedStatement.setInt(11, id);
            return preparedStatement.executeUpdate() > 0;

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.CATEGORY_DELETE);
            preparedStatement.setInt(1, ObjectStatus.DELETED.getValue());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;

        }catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category findById(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.CATEGORY_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, ObjectStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if (rs.getTimestamp("deletedAt") != null){
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                int createdBy = rs.getInt("createdBy");
                int updatedBy  = rs.getInt("updatedBy");
                int deletedBy  = rs.getInt("deletedBy");
                ObjectStatus status = ObjectStatus.values()[rs.getInt("status")];
                Category category = new Category(id, name, createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status);
                return category;
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.CATEGORY_FIND_ALL);
            preparedStatement.setInt(1, ObjectStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if(rs.getTimestamp("deletedAt") != null) {
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                int createdBy = rs.getInt("createdBy");
                int updatedBy = rs.getInt("updatedBy");
                int deletedBy = rs.getInt("deletedBy");
                ObjectStatus status = ObjectStatus.of(rs.getInt("status"));
                Category category = new Category(id, name, createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status);
                categories.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return categories;
    }
}
