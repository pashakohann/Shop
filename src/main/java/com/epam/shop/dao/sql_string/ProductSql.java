package com.epam.shop.dao.sql_string;

public interface ProductSql {
    String SQL_FIND_ALL_PRODUCTS = "SELECT id,name,category_id,brand_id,cost FROM products;";
    String SQL_FIND_ALL_PRODUCTS_WITH_CATEGORY = "SELECT id,name,category_id,brand_id,cost FROM products WHERE category_id = ?";
    String SQL_FIND_ALL_PRODUCTS_WITH_BRAND = "SELECT id,name,category_id,brand_id,cost FROM products WHERE brand_id = ?";
    String SQL_FIND_ALL_PRODUCTS_WITH_BRAND_AND_CATEGORY = "SELECT id,name,category_id,brand_id,cost FROM products WHERE brand_id =? and category_id=?;";
    String SQL_FIND_PRODUCT_BY_ID = "SELECT id,name,category_id,brand_id,cost FROM products WHERE id=?";
    String SQL_SAVE_PRODUCT = "INSERT INTO products(name,cost,category_id,brand_id)VALUES (?,?,?,?)";
    String SQL_DELETE_PRODUCT = "DELETE FROM products WHERE id=?";
    String SQL_UPDATE_PRODUCT = "UPDATE products SET name=?,cost=?,category_id=?,brand_id=? WHERE id=?";

}
