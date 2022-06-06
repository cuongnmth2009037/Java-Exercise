package com.example.product.t2009m1java.constant;

public class SqlConstant {
    public  static final String PRODUCT_INSERT = "INSERT INTO products (name, description, detail, price, thumbnail, manufactureEmail, manufacturePhone," +
            "createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    public static final String PRODUCT_UPDATE = "UPDATE products SET name = ?, description = ?, detail = ?, price = ?, thumbnail = ?, manufactureEmail = ?, manufacturePhone =?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ? WHERE id = ?";
    public static final String PRODUCT_DELETE = "DELETE FROM products WHERE id = ?";
    public static final String PRODUCT_UPDATE_STATUS = "UPDATE products SET status = ? WHERE id = ?";
    public static final String PRODUCT_FIND_BY_ID = "SELECT * FROM products WHERE id = ? AND status = ?";
    public static final String PRODUCT_FIND_ALL = "SELECT * FROM products WHERE status = ?";


    public  static final String CATEGORY_INSERT = "INSERT INTO categories (name, createdAt, updatedAt, createdBy, updatedBy, status) VALUES (?,?,?,?,?,?);";
    public static final String CATEGORY_UPDATE = "UPDATE products SET name = ?, createdAt = ?, updatedAt = ?, createdBy = ?, updatedBy = ?, status = ? WHERE id = ?";
    public static final String CATEGORY_DELETE = "DELETE FROM categories SET status = ?  WHERE id = ?";
    public static final String CATEGORY_FIND_BY_ID = "SELECT * FROM categories WHERE id = ? AND status = ?";
    public static final String CATEGORY_FIND_ALL = "SELECT * FROM categories WHERE status = ?";
}
