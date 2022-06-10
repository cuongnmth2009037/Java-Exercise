package com.example.product.t2009m1java.model;

import com.example.product.t2009m1java.entity.Account;

public interface AccountModel {
    boolean save(Account account);
    Account findByUsername(String username);
}
