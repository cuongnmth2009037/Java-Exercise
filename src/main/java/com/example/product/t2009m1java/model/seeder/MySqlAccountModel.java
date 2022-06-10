package com.example.product.t2009m1java.model.seeder;

import com.example.product.t2009m1java.constant.SqlConstant;
import com.example.product.t2009m1java.entity.Account;
import com.example.product.t2009m1java.entity.Product;
import com.example.product.t2009m1java.entity.entityEnum.ObjectStatus;
import com.example.product.t2009m1java.model.AccountModel;
import com.example.product.t2009m1java.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MySqlAccountModel implements AccountModel {
    @Override
    public boolean save(Account account) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ACCOUNT_INSERT);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, account.getRoleId());
            preparedStatement.setString(4, account.getCreatedAt().toString());
            preparedStatement.setString(5, account.getUpdatedAt().toString());
            preparedStatement.setInt(6, account.getStatus().getValue());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Account findByUsername(String username) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ACCOUNT_FIND_BY_USERNAME);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, ObjectStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String userName = rs.getString("username");
                String password = rs.getString("password");
                Account account = new Account();
                account.setPassword(password);
                account.setUsername(userName);
                return account;
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }
}
