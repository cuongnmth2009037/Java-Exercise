package com.example.product.t2009m1java.service;

import com.example.product.t2009m1java.entity.Account;
import com.example.product.t2009m1java.model.AccountModel;
import com.example.product.t2009m1java.model.seeder.MySqlAccountModel;
import com.example.product.t2009m1java.util.SHA512Hasher;

public class AccountService {
    private AccountModel accountModel;
    public AccountService(){
        this.accountModel = new MySqlAccountModel();
    }

    public Account register(Account account){
        String salt = SHA512Hasher.randomString(7);
        String passwordHashn= SHA512Hasher.encode(account.getPassword(), salt);
        account.setPassword(passwordHashn + "." + salt);
        accountModel.save(account);
        return account;
    }

    public Account login(String username, String password){
        Account account = accountModel.findByUsername(username);
        if (account != null && SHA512Hasher.checkPassword(account.getPassword(), password)){
            return account;
        }
        return null;
    }

}
