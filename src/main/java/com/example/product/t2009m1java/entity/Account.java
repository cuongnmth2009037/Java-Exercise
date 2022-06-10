package com.example.product.t2009m1java.entity;

import com.example.product.t2009m1java.entity.base.BaseEntity;
import com.example.product.t2009m1java.entity.entityEnum.ObjectStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Account extends BaseEntity {
    private int id;
    private String username;
    private String password;
    private String confirmPassword;
    private int roleId; // 1. user | 2. admin
    private HashMap<String, String> errors;

    public Account() {
        errors = new HashMap<>();
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }
    public boolean isValid() {
        return this.checkValid();
    }

    public boolean checkValid() {
        if (username == "" || username == null) {
            errors.put("name", "Please enter name");
        }
        return errors.size() == 0;
    }

    public Account(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ObjectStatus status, int id, String username, String password, String confirmPassword, int roleId) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status);
        this.id = id;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.roleId = roleId;
        errors = new HashMap<>();
    }
    public Account(int id, String username, String email, String password, String confirmPassword, String fullName, int roleId, ObjectStatus status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.roleId = roleId;
        this.status = status;
        errors = new HashMap<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public ObjectStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(ObjectStatus status) {
        this.status = status;
    }


    public static final class AccountBuilder {
        public LocalDateTime createdAt;
        public LocalDateTime updatedAt;
        public LocalDateTime deletedAt;
        public int createdBy;
        public int updatedBy;
        public int deletedBy;
        public ObjectStatus status;
        private int id;
        private String username;
        private String password;
        private String confirmPassword;
        private int roleId; // 1. user | 2. admin

        private AccountBuilder() {
            this.username = "";
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
            this.status = ObjectStatus.ACTIVE;
        }

        public static AccountBuilder anAccount() {
            return new AccountBuilder();
        }

        public AccountBuilder id(int id) {
            this.id = id;
            return this;
        }

        public AccountBuilder username(String username) {
            this.username = username;
            return this;
        }

        public AccountBuilder password(String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder confirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public AccountBuilder roleId(int roleId) {
            this.roleId = roleId;
            return this;
        }

        public AccountBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccountBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public AccountBuilder deletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public AccountBuilder createdBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccountBuilder updatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public AccountBuilder deletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public AccountBuilder status(ObjectStatus status) {
            this.status = status;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.setId(id);
            account.setUsername(username);
            account.setPassword(password);
            account.setConfirmPassword(confirmPassword);
            account.setRoleId(roleId);
            account.setCreatedAt(createdAt);
            account.setUpdatedAt(updatedAt);
            account.setDeletedAt(deletedAt);
            account.setCreatedBy(createdBy);
            account.setUpdatedBy(updatedBy);
            account.setDeletedBy(deletedBy);
            account.setStatus(status);
            return account;
        }




    }
}
