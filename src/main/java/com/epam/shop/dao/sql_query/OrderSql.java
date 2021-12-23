package com.epam.shop.dao.sql_query;

/**
 * all queries from order to db
 */
public interface OrderSql {
    String SQL_SAVE_ORDER = "INSERT INTO orders(order_cost,account_id,order_date) VALUES(?,?,?)";
    String SQL_FIND_ORDER_BY_ID= "SELECT id,order_date,order_cost,account_id FROM orders WHERE id=?";
    String SQL_FIND_ALL_ORDERS = "SELECT id,order_date,order_cost,account_id FROM orders";
    String SQL_FIND_ALL_PRODUCTS_FROM_ORDER="SELECT id,name,cost,category_id,brand_id,photo_link, orders_products.quantity FROM products CROSS JOIN orders_products ON products.id = orders_products.product_id AND orders_products.order_id=?";
    String SQL_ADD_PRODUCTS_IN_ORDER = "INSERT INTO orders_products(order_id,product_id,quantity)VALUES(?,?,?)";
    String SQL_DELETE_ORDER = "DELETE FROM orders WHERE id=?";
    String SQL_DELETE_ALL_PRODUCTS_FROM_ORDER = "DELETE FROM orders_products WHERE order_id = ?";

}
