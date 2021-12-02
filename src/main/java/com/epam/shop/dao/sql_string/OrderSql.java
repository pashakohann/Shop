package com.epam.shop.dao.sql_string;

public interface OrderSql {
    String SQL_SAVE_ORDER = "INSERT INTO orders(order_cost,account_id) VALUES(?,?)";
    String SQL_FIND_ORDER_BY_ID= "SELECT id,order_date,order_cost,account_id FROM orders WHERE id=?";
    String SQL_FIND_ALL_ORDERS = "SELECT id,order_date,order_cost,account_id FROM orders";
    String SQL_FIND_ALL_PRODUCTS_FROM_ORDER="SELECT id,name,cost,category_id,brand_id FROM products WHERE id IN(SELECT product_id FROM orders_products WHERE order_id = ?)";
    String SQL_ADD_PRODUCTS_IN_ORDER = "INSERT INTO orders_products(order_id,product_id)VALUES(?,?)";
    String SQL_DELETE_PRODUCT_IN_ORDER="DELETE FROM orders_products WHERE product_id=?";
    String SQL_DELETE_ORDER = "DELETE FROM orders WHERE id=?";
    String SQL_DELETE_ALL_PRODUCTS_FROM_ORDER = "DELETE FROM orders_products WHERE order_id = ?";

}
