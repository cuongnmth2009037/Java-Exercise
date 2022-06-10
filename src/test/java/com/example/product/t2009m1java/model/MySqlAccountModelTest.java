package com.example.product.t2009m1java.model;

import com.example.product.t2009m1java.entity.Account;
import com.example.product.t2009m1java.model.seeder.MySqlAccountModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlAccountModelTest {
    private AccountModel accountModel;

    @BeforeEach
    void setUp() {accountModel = new MySqlAccountModel();}

    @Test
    void save() {
        Account account = new Account();
        account.setUsername("cuong");
        account.setPassword("12345");
        account.setConfirmPassword("12345");
        assertEquals(true,accountModel.save(account));
    }
}