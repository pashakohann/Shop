package com.epam.shop.dao.exception.string_exception;
/**
 * Strings for our exceptions from Dao product
 */
public interface DaoProductExceptionString {
    String SQL_FIND_ALL_PRODUCTS_EXCEPTION = "Failed to find products";
    String SQL_FIND_ALL_PRODUCTS_WITH_CATEGORY_EXCEPTION = "Failed to find products with the category";
    String SQL_FIND_ALL_PRODUCTS_WITH_BRAND_EXCEPTION = "Failed to find products with the brand";
    String SQL_FIND_ALL_PRODUCTS_WITH_BRAND_AND_CATEGORY_EXCEPTION = "Failed to find products with such brand and category ";
    String SQL_FIND_PRODUCT_BY_ID_EXCEPTION = "Failed to find product";
    String SQL_SAVE_PRODUCT_EXCEPTION = "Failed to save product";
    String SQL_DELETE_PRODUCT_EXCEPTION = "Failed to delete product,maybe the product was ordered";
    String SQL_UPDATE_PRODUCT_EXCEPTION = "Failed to update product";


}
